package com.bootmybatis.batch;

import com.bootmybatis.model.BatchBean;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemStreamException;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.core.io.Resource;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by mr on 2018/12/29.
 */
public class ExcelItemReader extends FlatFileItemReader {

    private Resource resource;
    private Integer sheetNum = 0;
    private Integer headLineRow = 0;
    private Boolean isCopied = false;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

    private Sheet sheet;
    private Integer lineCount;
    private Integer totalRows;

    private static final Log logger = LogFactory.getLog(ExcelItemReader.class);

    public void setHeadLineRow(Integer headLineRow) {
        this.headLineRow = headLineRow;
    }

    @Override
    public void setResource(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        logger.info("afterPropertiesSet...");
    }

    @Override
    public void open(ExecutionContext executioncontext) throws ItemStreamException {
        logger.info("打开Excel表...");
        //获取文件名
        String fileName = resource.getFilename();
        Workbook workbook = null;
        try {
            InputStream inputStream = resource.getInputStream();
            //是否拷贝文件
            if (isCopied) {
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                int b = 0;
                while ((b = inputStream.read()) != -1) {
                    bos.write(b);
                }
                ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
                inputStream = bis;
            }
            //判断Excel版本
            if (fileName.toUpperCase().indexOf(".XLSX") != -1) {
                workbook = new XSSFWorkbook(inputStream);
            } else {
                workbook = new HSSFWorkbook(inputStream);
            }
            //获取指定的sheet
            sheet = workbook.getSheetAt(sheetNum);
            if (sheet == null) {
                throw new ItemStreamException("找不到Sheet表");
            }

            lineCount = headLineRow + 1;

            int lastRowNum = sheet.getLastRowNum();
            int physicalNumberOfRows = sheet.getPhysicalNumberOfRows();
            totalRows = physicalNumberOfRows < lastRowNum ? physicalNumberOfRows : lastRowNum;

            logger.info("lastRowNum:" + lastRowNum);
            logger.info("physicalNumberOfRows:" + physicalNumberOfRows);
            logger.info("total rows:" + totalRows);

        } catch (IOException e) {
            logger.error("open excel fail!", e);
            throw new ItemStreamException(e);
        }

    }


    @Override
    public Object read() throws Exception{
        logger.info("读取行号:" + lineCount);
        if (lineCount >= totalRows) {
            logger.info("read over all rows!");
            return null;
        }

        BatchBean batchBean=new BatchBean();
        Row dataRow = sheet.getRow(lineCount);
        batchBean.setDataName(getStringVal(dataRow.getCell(0)));
        batchBean.setDataNo(getStringVal(dataRow.getCell(1)));
        batchBean.setDataPay(getStringVal(dataRow.getCell(2)));
        batchBean.setDataTime(getStringVal(dataRow.getCell(3)));
        batchBean.setDataCust(getStringVal(dataRow.getCell(4)));

        lineCount++;
        return batchBean;
    }

    private String getStringVal(Cell cell){
        if(cell!=null&&null!=cell.getCellTypeEnum()){
            switch (cell.getCellTypeEnum()) {
                case NUMERIC:
                    if (HSSFDateUtil.isCellDateFormatted(cell)) {
                        Date date = cell.getDateCellValue();
                        return dateFormat.format(date);
                    }
                    return cell.getNumericCellValue() + "";
                default:
                    return cell.getStringCellValue();
            }
        }
        return "";
    }

    @Override
    public void close() throws ItemStreamException {
        try {
            resource.getInputStream().close();
        } catch (IOException e) {
            logger.error("close failed!", e);
            throw new ItemStreamException(e);
        }
    }

    @Override
    public void update(ExecutionContext executioncontext)
            throws ItemStreamException {
        logger.info("update...");
    }
}

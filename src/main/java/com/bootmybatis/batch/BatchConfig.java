package com.bootmybatis.batch;

import com.bootmybatis.model.BatchBean;
import org.mybatis.spring.batch.MyBatisBatchItemWriter;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.JobRepositoryFactoryBean;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.item.file.transform.LineTokenizer;
import org.springframework.batch.item.validator.Validator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * 配置
 * Created by mr on 2018/12/29.
 */
//@Configuration
//@EnableBatchProcessing
public class BatchConfig {

    //@Bean
    public ItemReader<BatchBean> reader() throws Exception {
        //FlatFileItemReader<BatchBean> reader = new FlatFileItemReader<BatchBean>();
        ExcelItemReader reader=new ExcelItemReader();
        reader.setResource(new ClassPathResource("data.xlsx"));
        /*reader.setLineMapper(new DefaultLineMapper<BatchBean>() {
            {
                setLineTokenizer(new DelimitedLineTokenizer() {
                    {
                        setNames(new String[]{"dataName", "dataNo", "dataPay", "dataTime", "dataCust", "dataResult"});
                    }
                });
                setFieldSetMapper(new BeanWrapperFieldSetMapper<BatchBean>() {
                    {
                        setTargetType(BatchBean.class);
                    }
                });
            }
        });*/
        return reader;
    }

    //@Bean
    public ItemProcessor<BatchBean, BatchBean> processor() {
        BatchItemProcessor processor = new BatchItemProcessor();
        processor.setValidator(batchBeanValidator());
        return processor;
    }

    //@Bean
    public ItemWriter<BatchBean> writer(DataSource dataSource) {
        JdbcBatchItemWriter<BatchBean> writer = new JdbcBatchItemWriter<BatchBean>();
        writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<BatchBean>());
        String sql = "insert into batch_bean (DATA_NAME,DATA_NO,DATA_PAY,DATA_TIME,DATA_CUST,DATA_RESULT) values (:dataName,:dataNo,:dataPay,:dataTime,:dataCust,:dataResult)";
        writer.setSql(sql);
        writer.setDataSource(dataSource);
        return writer;
    }

    //@Bean
    public JobRepository jobRepository(DataSource dataSource, PlatformTransactionManager transactionManager) throws Exception {
        JobRepositoryFactoryBean jobRepositoryFactoryBean = new JobRepositoryFactoryBean();
        jobRepositoryFactoryBean.setDataSource(dataSource);
        jobRepositoryFactoryBean.setTransactionManager(transactionManager);
        jobRepositoryFactoryBean.setDatabaseType("mysql");
        return jobRepositoryFactoryBean.getObject();
    }

    //@Bean
    public SimpleJobLauncher jobLauncher(DataSource dataSource, PlatformTransactionManager transactionManager) throws Exception {
        SimpleJobLauncher simpleJobLauncher = new SimpleJobLauncher();
        simpleJobLauncher.setJobRepository(jobRepository(dataSource, transactionManager));
        return simpleJobLauncher;
    }

    //@Bean
    public Job importJob(JobBuilderFactory jobs, Step s1) {
        return jobs.get("importJob").incrementer(new RunIdIncrementer()).flow(s1).end().listener(batchJobListener()).build();
    }

    //@Bean
    public Step step1(StepBuilderFactory stepBuilderFactory,ItemReader<BatchBean> reader,ItemWriter<BatchBean> writer,ItemProcessor<BatchBean,BatchBean> processor){
        return stepBuilderFactory.get("step1").<BatchBean,BatchBean>chunk(10000).reader(reader).processor(processor).writer(writer).build();
    }

    //@Bean
    public BatchJobListener batchJobListener() {
        return new BatchJobListener();
    }

    //@Bean
    public Validator<BatchBean> batchBeanValidator() {
        return new BatchBeanValidator<BatchBean>();
    }

}

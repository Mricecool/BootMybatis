package com.bootmybatis.model;

/**
 * Created by mr on 2018/12/25.
 */
public class Card {

    private String cardName;
    private String cardNo;

    /**
     * 获取
     *
     * @return
     */
    public String getCardName() {
        return cardName;
    }

    /**
     * 设置
     *
     * @param cardName
     */
    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    /**
     * 获取
     *
     * @return
     */
    public String getCardNo() {
        return cardNo;
    }

    /**
     * 设置
     *
     * @param cardNo
     */
    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }
}

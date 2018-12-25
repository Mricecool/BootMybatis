package com.bootmybatis.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

/**
 * Created by mr on 2018/12/25.
 */
@Document
public class Person {
    @Id
    private int pId;
    private String pName;
    @Field("cards")
    private List<Card> cards;

    /**
     * 获取
     *
     * @return
     */
    public int getpId() {
        return pId;
    }

    /**
     * 设置
     *
     * @param pId
     */
    public void setpId(int pId) {
        this.pId = pId;
    }

    /**
     * 获取
     *
     * @return
     */
    public String getpName() {
        return pName;
    }

    /**
     * 设置
     *
     * @param pName
     */
    public void setpName(String pName) {
        this.pName = pName;
    }

    /**
     * 获取
     *
     * @return
     */
    public List<Card> getCards() {
        return cards;
    }

    /**
     * 设置
     *
     * @param cards
     */
    public void setCards(List<Card> cards) {
        this.cards = cards;
    }
}

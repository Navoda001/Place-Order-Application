/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.mvc.dto;

/**
 *
 * @author Navoda Chathurya
 */
public class ItemDto {
    private String code;
    private String description;
    private String packSize;
    private Double untPrice;
    private Integer qoh;

    public ItemDto() {
    }

    public ItemDto(String code, String description, String packSize, Double untPrice, Integer qoh) {
        this.code = code;
        this.description = description;
        this.packSize = packSize;
        this.untPrice = untPrice;
        this.qoh = qoh;
    }

    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the packSize
     */
    public String getPackSize() {
        return packSize;
    }

    /**
     * @param packSize the packSize to set
     */
    public void setPackSize(String packSize) {
        this.packSize = packSize;
    }

    /**
     * @return the untPrice
     */
    public Double getUntPrice() {
        return untPrice;
    }

    /**
     * @param untPrice the untPrice to set
     */
    public void setUntPrice(Double untPrice) {
        this.untPrice = untPrice;
    }

    /**
     * @return the qoh
     */
    public Integer getQoh() {
        return qoh;
    }

    /**
     * @param qoh the qoh to set
     */
    public void setQoh(Integer qoh) {
        this.qoh = qoh;
    }

    @Override
    public String toString() {
        return "ItemDto{" + "code=" + code + ", description=" + description + ", packSize=" + packSize + ", untPrice=" + untPrice + ", qoh=" + qoh + '}';
    }
    
    
}

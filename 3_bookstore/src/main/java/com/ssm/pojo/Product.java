package com.ssm.pojo;

import java.util.Date;

public class Product {
    private String pid;

    private String pname;

    private Double marketPrice;

    private Double shopPrice;

    private String pimage;

    private Date pdate;

    private Integer isHot;

    private String pdesc;

    private Integer pflag;

    private String cid;
    
    private Category category;//为了在商品详情页显示分类

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid == null ? null : pid.trim();
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname == null ? null : pname.trim();
    }

    public Double getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(Double marketPrice) {
        this.marketPrice = marketPrice;
    }

    public Double getShopPrice() {
        return shopPrice;
    }

    public void setShopPrice(Double shopPrice) {
        this.shopPrice = shopPrice;
    }

    public String getPimage() {
        return pimage;
    }

    public void setPimage(String pimage) {
        this.pimage = pimage == null ? null : pimage.trim();
    }

    public Date getPdate() {
        return pdate;
    }

    public void setPdate(Date pdate) {
        this.pdate = pdate;
    }

    public Integer getIsHot() {
        return isHot;
    }

    public void setIsHot(Integer isHot) {
        this.isHot = isHot;
    }

    public String getPdesc() {
        return pdesc;
    }

    public void setPdesc(String pdesc) {
        this.pdesc = pdesc == null ? null : pdesc.trim();
    }

    public Integer getPflag() {
        return pflag;
    }

    public void setPflag(Integer pflag) {
        this.pflag = pflag;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid == null ? null : cid.trim();
    }

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Product [pid=").append(pid).append(", pname=").append(pname).append(", marketPrice=")
				.append(marketPrice).append(", shopPrice=").append(shopPrice).append(", pimage=").append(pimage)
				.append(", pdate=").append(pdate).append(", isHot=").append(isHot).append(", pdesc=").append(pdesc)
				.append(", pflag=").append(pflag).append(", cid=").append(cid).append(", category=").append(category)
				.append("]");
		return builder.toString();
	}
}
package com.lrcf.yhb.pojo;

import java.io.Serializable;
import java.util.Date;

public class ArticleDetail implements Serializable {
    private Integer id;

    private Byte type;

    private String title;

    private String sonTitle;

    private Integer weight;

    private String imgName;

    private String imgAddress;

    private Date createTime;

    private String videoName;

    private String videoAddress;

    private Integer status;

    private Long browseCount;

    private String author;

    private Integer emp1;

    private String emp2;

    private String emp3;

    private String emp4;

    private String context;

    private Date time;

    private String summary;

    private String img;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSonTitle() {
        return sonTitle;
    }

    public void setSonTitle(String sonTitle) {
        this.sonTitle = sonTitle;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }

    public String getImgAddress() {
        return imgAddress;
    }

    public void setImgAddress(String imgAddress) {
        this.imgAddress = imgAddress;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getVideoName() {
        return videoName;
    }

    public void setVideoName(String videoName) {
        this.videoName = videoName;
    }

    public String getVideoAddress() {
        return videoAddress;
    }

    public void setVideoAddress(String videoAddress) {
        this.videoAddress = videoAddress;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getBrowseCount() {
        return browseCount;
    }

    public void setBrowseCount(Long browseCount) {
        this.browseCount = browseCount;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getEmp1() {
        return emp1;
    }

    public void setEmp1(Integer emp1) {
        this.emp1 = emp1;
    }

    public String getEmp2() {
        return emp2;
    }

    public void setEmp2(String emp2) {
        this.emp2 = emp2;
    }

    public String getEmp3() {
        return emp3;
    }

    public void setEmp3(String emp3) {
        this.emp3 = emp3;
    }

    public String getEmp4() {
        return emp4;
    }

    public void setEmp4(String emp4) {
        this.emp4 = emp4;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        ArticleDetail other = (ArticleDetail) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getSonTitle() == null ? other.getSonTitle() == null : this.getSonTitle().equals(other.getSonTitle()))
            && (this.getWeight() == null ? other.getWeight() == null : this.getWeight().equals(other.getWeight()))
            && (this.getImgName() == null ? other.getImgName() == null : this.getImgName().equals(other.getImgName()))
            && (this.getImgAddress() == null ? other.getImgAddress() == null : this.getImgAddress().equals(other.getImgAddress()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getVideoName() == null ? other.getVideoName() == null : this.getVideoName().equals(other.getVideoName()))
            && (this.getVideoAddress() == null ? other.getVideoAddress() == null : this.getVideoAddress().equals(other.getVideoAddress()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getBrowseCount() == null ? other.getBrowseCount() == null : this.getBrowseCount().equals(other.getBrowseCount()))
            && (this.getAuthor() == null ? other.getAuthor() == null : this.getAuthor().equals(other.getAuthor()))
            && (this.getEmp1() == null ? other.getEmp1() == null : this.getEmp1().equals(other.getEmp1()))
            && (this.getEmp2() == null ? other.getEmp2() == null : this.getEmp2().equals(other.getEmp2()))
            && (this.getEmp3() == null ? other.getEmp3() == null : this.getEmp3().equals(other.getEmp3()))
            && (this.getEmp4() == null ? other.getEmp4() == null : this.getEmp4().equals(other.getEmp4()))
            && (this.getContext() == null ? other.getContext() == null : this.getContext().equals(other.getContext()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getSonTitle() == null) ? 0 : getSonTitle().hashCode());
        result = prime * result + ((getWeight() == null) ? 0 : getWeight().hashCode());
        result = prime * result + ((getImgName() == null) ? 0 : getImgName().hashCode());
        result = prime * result + ((getImgAddress() == null) ? 0 : getImgAddress().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getVideoName() == null) ? 0 : getVideoName().hashCode());
        result = prime * result + ((getVideoAddress() == null) ? 0 : getVideoAddress().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getBrowseCount() == null) ? 0 : getBrowseCount().hashCode());
        result = prime * result + ((getAuthor() == null) ? 0 : getAuthor().hashCode());
        result = prime * result + ((getEmp1() == null) ? 0 : getEmp1().hashCode());
        result = prime * result + ((getEmp2() == null) ? 0 : getEmp2().hashCode());
        result = prime * result + ((getEmp3() == null) ? 0 : getEmp3().hashCode());
        result = prime * result + ((getEmp4() == null) ? 0 : getEmp4().hashCode());
        result = prime * result + ((getContext() == null) ? 0 : getContext().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", type=").append(type);
        sb.append(", title=").append(title);
        sb.append(", sonTitle=").append(sonTitle);
        sb.append(", weight=").append(weight);
        sb.append(", imgName=").append(imgName);
        sb.append(", imgAddress=").append(imgAddress);
        sb.append(", createTime=").append(createTime);
        sb.append(", videoName=").append(videoName);
        sb.append(", videoAddress=").append(videoAddress);
        sb.append(", status=").append(status);
        sb.append(", browseCount=").append(browseCount);
        sb.append(", author=").append(author);
        sb.append(", emp1=").append(emp1);
        sb.append(", emp2=").append(emp2);
        sb.append(", emp3=").append(emp3);
        sb.append(", emp4=").append(emp4);
        sb.append(", context=").append(context);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
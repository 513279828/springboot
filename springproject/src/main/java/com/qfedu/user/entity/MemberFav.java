package com.qfedu.user.entity;

public class MemberFav {
    private Long id;

    private Long memberId;

    private Byte favType;

    private Long contentId;

    private Integer favTime;

    private String favIp;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Byte getFavType() {
        return favType;
    }

    public void setFavType(Byte favType) {
        this.favType = favType;
    }

    public Long getContentId() {
        return contentId;
    }

    public void setContentId(Long contentId) {
        this.contentId = contentId;
    }

    public Integer getFavTime() {
        return favTime;
    }

    public void setFavTime(Integer favTime) {
        this.favTime = favTime;
    }

    public String getFavIp() {
        return favIp;
    }

    public void setFavIp(String favIp) {
        this.favIp = favIp == null ? null : favIp.trim();
    }
}
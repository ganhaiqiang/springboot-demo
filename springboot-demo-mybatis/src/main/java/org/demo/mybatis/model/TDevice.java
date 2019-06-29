package org.demo.mybatis.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import tk.mybatis.mapper.annotation.KeySql;

@Table(name = "t_device")
public class TDevice implements Serializable {
	@Id
	@KeySql(useGeneratedKeys = true)
	@Column(name = "ID")
	private Integer id;

	/**
	 * 设备生成硬件识别号
	 */
	@Column(name = "UNIQUE_ID")
	private String uniqueId;

	/**
	 * 设备唯一ID，32位
	 */
	@Column(name = "UUID")
	private String uuid;

	/**
	 * 媒体方设备ID
	 */
	@Column(name = "THIRD_ID")
	private String thirdId;

	/**
	 * 账号ID
	 */
	@Column(name = "ACCOUNT_ID")
	private Integer accountId;

	/**
	 * 设备类型ID
	 */
	@Column(name = "DEVICE_TYPE_ID")
	private Integer deviceTypeId;

	/**
	 * 分组ID
	 */
	@Column(name = "GROUP_ID")
	private Integer groupId;

	/**
	 * 设备名称
	 */
	@Column(name = "NAME")
	private String name;

	@Column(name = "WIDTH")
	private String width;

	@Column(name = "HEIGHT")
	private String height;

	@Column(name = "WIDTH_CM")
	private String widthCm;

	@Column(name = "HEIGHT_CM")
	private String heightCm;

	/**
	 * 状态，UNK - 未知，ONL - 在线，OFL - 离线，N - 已失效, INA - 未激活
	 */
	@Column(name = "STATUS")
	private String status;

	/**
	 * 是否开放
	 */
	@Column(name = "OPEN")
	private String open;

	@Column(name = "PROVINCE")
	private String province;

	/**
	 * 省
	 */
	@Column(name = "PROVINCE_CODE")
	private String provinceCode;

	/**
	 * 市
	 */
	@Column(name = "CITY")
	private String city;

	@Column(name = "CITY_CODE")
	private String cityCode;

	/**
	 * 区
	 */
	@Column(name = "DISTRICT")
	private String district;

	/**
	 * 地区编码
	 */
	@Column(name = "DISTRICT_CODE")
	private String districtCode;

	/**
	 * 地址
	 */
	@Column(name = "ADDRESS")
	private String address;

	/**
	 * 经度
	 */
	@Column(name = "LONGITUDE")
	private BigDecimal longitude;

	/**
	 * 维度
	 */
	@Column(name = "LATITUDE")
	private BigDecimal latitude;

	/**
	 * 设备对接方式
	 */
	@Column(name = "JOIN_TYPE")
	private String joinType;

	/**
	 * POI名称
	 */
	@Column(name = "POI")
	private String poi;

	/**
	 * POI地址
	 */
	@Column(name = "POI_ADDRESS")
	private String poiAddress;

	/**
	 * 是否联网
	 */
	@Column(name = "IS_NET")
	private String isNet;

	/**
	 * 屏幕尺寸（单位：英寸）
	 */
	@Column(name = "SIZE")
	private Double size;

	/**
	 * 标签
	 */
	@Column(name = "LABELS")
	private String labels;

	@Column(name = "CRM_CODE")
	private String crmCode;

	/**
	 * 组合ID，用于一机多主
	 */
	@Column(name = "COMBINED_ID")
	private Integer combinedId;

	/**
	 * 型号
	 */
	@Column(name = "MODEL")
	private String model;

	/**
	 * 品牌
	 */
	@Column(name = "BRAND")
	private String brand;

	/**
	 * 屏幕数量
	 */
	@Column(name = "SCREEN_QUANTITY")
	private Integer screenQuantity;

	/**
	 * 每日接触人数
	 */
	@Column(name = "SEE_NUM")
	private Integer seeNum;

	/**
	 * iot物联网通信secret
	 */
	@Column(name = "SECRET")
	private String secret;

	/**
	 * 【自动升级版本区分】易信发yxf、中性neu、天使盒子angle_box、金嵘达jrd
	 */
	@Column(name = "APP_TYPE")
	private String appType;

	/**
	 * 设备播放类型 G/D
	 */
	@Column(name = "PAY_TYPE")
	private String payType;

	/**
	 * 设备类型名称
	 */
	@Column(name = "DEVICE_TYPE_NAME")
	private String deviceTypeName;

	/**
	 * 心跳时间
	 */
	@Column(name = "HEARTBEAT_TIME")
	private Date heartbeatTime;

	@Column(name = "COMMENT")
	private String comment;

	@Column(name = "DEVICE_NAME")
	private String deviceName;

	/**
	 * 结款状态 （1：已付款，2：待付款）
	 */
	@Column(name = "PAYMENT_STATUS")
	private Boolean paymentStatus;

	/**
	 * 设备单价(分)
	 */
	@Column(name = "DEVICE_PRICE")
	private BigDecimal devicePrice;

	@Column(name = "CREATE_TIME")
	private Date createTime;

	@Column(name = "UPDATE_TIME")
	private Date updateTime;

	/**
	 * 是否可售
	 */
	@Column(name = "IS_SALE")
	private String isSale;

	/**
	 * 售卖方式
	 */
	@Column(name = "SALE_TYPE")
	private String saleType;

	/**
	 * 百度是否备案；Y-是，N-否
	 */
	@Column(name = "BAIDU_FLAG")
	private String baiduFlag;

	@Column(name = "ip")
	private String ip;

	/**
	 * 可否程序化投放
	 */
	@Column(name = "auto_serving")
	private String autoServing;

	/**
	 * 是否导入投个屏
	 */
	@Column(name = "import_tgp")
	private String importTgp;

	/**
	 * 投个屏设备状态(Y-启用，N-禁用)
	 */
	@Column(name = "tgp_status")
	private String tgpStatus;

	/**
	 * 投个屏二维码
	 */
	@Column(name = "qrcode")
	private String qrcode;

	private static final long serialVersionUID = 1L;

	/**
	 * @return ID
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 获取设备生成硬件识别号
	 *
	 * @return UNIQUE_ID - 设备生成硬件识别号
	 */
	public String getUniqueId() {
		return uniqueId;
	}

	/**
	 * 设置设备生成硬件识别号
	 *
	 * @param uniqueId 设备生成硬件识别号
	 */
	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId == null ? null : uniqueId.trim();
	}

	/**
	 * 获取设备唯一ID，32位
	 *
	 * @return UUID - 设备唯一ID，32位
	 */
	public String getUuid() {
		return uuid;
	}

	/**
	 * 设置设备唯一ID，32位
	 *
	 * @param uuid 设备唯一ID，32位
	 */
	public void setUuid(String uuid) {
		this.uuid = uuid == null ? null : uuid.trim();
	}

	/**
	 * 获取媒体方设备ID
	 *
	 * @return THIRD_ID - 媒体方设备ID
	 */
	public String getThirdId() {
		return thirdId;
	}

	/**
	 * 设置媒体方设备ID
	 *
	 * @param thirdId 媒体方设备ID
	 */
	public void setThirdId(String thirdId) {
		this.thirdId = thirdId == null ? null : thirdId.trim();
	}

	/**
	 * 获取账号ID
	 *
	 * @return ACCOUNT_ID - 账号ID
	 */
	public Integer getAccountId() {
		return accountId;
	}

	/**
	 * 设置账号ID
	 *
	 * @param accountId 账号ID
	 */
	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	/**
	 * 获取设备类型ID
	 *
	 * @return DEVICE_TYPE_ID - 设备类型ID
	 */
	public Integer getDeviceTypeId() {
		return deviceTypeId;
	}

	/**
	 * 设置设备类型ID
	 *
	 * @param deviceTypeId 设备类型ID
	 */
	public void setDeviceTypeId(Integer deviceTypeId) {
		this.deviceTypeId = deviceTypeId;
	}

	/**
	 * 获取分组ID
	 *
	 * @return GROUP_ID - 分组ID
	 */
	public Integer getGroupId() {
		return groupId;
	}

	/**
	 * 设置分组ID
	 *
	 * @param groupId 分组ID
	 */
	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	/**
	 * 获取设备名称
	 *
	 * @return NAME - 设备名称
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设置设备名称
	 *
	 * @param name 设备名称
	 */
	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	/**
	 * @return WIDTH
	 */
	public String getWidth() {
		return width;
	}

	/**
	 * @param width
	 */
	public void setWidth(String width) {
		this.width = width == null ? null : width.trim();
	}

	/**
	 * @return HEIGHT
	 */
	public String getHeight() {
		return height;
	}

	/**
	 * @param height
	 */
	public void setHeight(String height) {
		this.height = height == null ? null : height.trim();
	}

	/**
	 * @return WIDTH_CM
	 */
	public String getWidthCm() {
		return widthCm;
	}

	/**
	 * @param widthCm
	 */
	public void setWidthCm(String widthCm) {
		this.widthCm = widthCm == null ? null : widthCm.trim();
	}

	/**
	 * @return HEIGHT_CM
	 */
	public String getHeightCm() {
		return heightCm;
	}

	/**
	 * @param heightCm
	 */
	public void setHeightCm(String heightCm) {
		this.heightCm = heightCm == null ? null : heightCm.trim();
	}

	/**
	 * 获取状态，UNK - 未知，ONL - 在线，OFL - 离线，N - 已失效, INA - 未激活
	 *
	 * @return STATUS - 状态，UNK - 未知，ONL - 在线，OFL - 离线，N - 已失效, INA - 未激活
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * 设置状态，UNK - 未知，ONL - 在线，OFL - 离线，N - 已失效, INA - 未激活
	 *
	 * @param status 状态，UNK - 未知，ONL - 在线，OFL - 离线，N - 已失效, INA - 未激活
	 */
	public void setStatus(String status) {
		this.status = status == null ? null : status.trim();
	}

	/**
	 * 获取是否开放
	 *
	 * @return OPEN - 是否开放
	 */
	public String getOpen() {
		return open;
	}

	/**
	 * 设置是否开放
	 *
	 * @param open 是否开放
	 */
	public void setOpen(String open) {
		this.open = open == null ? null : open.trim();
	}

	/**
	 * @return PROVINCE
	 */
	public String getProvince() {
		return province;
	}

	/**
	 * @param province
	 */
	public void setProvince(String province) {
		this.province = province == null ? null : province.trim();
	}

	/**
	 * 获取省
	 *
	 * @return PROVINCE_CODE - 省
	 */
	public String getProvinceCode() {
		return provinceCode;
	}

	/**
	 * 设置省
	 *
	 * @param provinceCode 省
	 */
	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode == null ? null : provinceCode.trim();
	}

	/**
	 * 获取市
	 *
	 * @return CITY - 市
	 */
	public String getCity() {
		return city;
	}

	/**
	 * 设置市
	 *
	 * @param city 市
	 */
	public void setCity(String city) {
		this.city = city == null ? null : city.trim();
	}

	/**
	 * @return CITY_CODE
	 */
	public String getCityCode() {
		return cityCode;
	}

	/**
	 * @param cityCode
	 */
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode == null ? null : cityCode.trim();
	}

	/**
	 * 获取区
	 *
	 * @return DISTRICT - 区
	 */
	public String getDistrict() {
		return district;
	}

	/**
	 * 设置区
	 *
	 * @param district 区
	 */
	public void setDistrict(String district) {
		this.district = district == null ? null : district.trim();
	}

	/**
	 * 获取地区编码
	 *
	 * @return DISTRICT_CODE - 地区编码
	 */
	public String getDistrictCode() {
		return districtCode;
	}

	/**
	 * 设置地区编码
	 *
	 * @param districtCode 地区编码
	 */
	public void setDistrictCode(String districtCode) {
		this.districtCode = districtCode == null ? null : districtCode.trim();
	}

	/**
	 * 获取地址
	 *
	 * @return ADDRESS - 地址
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * 设置地址
	 *
	 * @param address 地址
	 */
	public void setAddress(String address) {
		this.address = address == null ? null : address.trim();
	}

	/**
	 * 获取经度
	 *
	 * @return LONGITUDE - 经度
	 */
	public BigDecimal getLongitude() {
		return longitude;
	}

	/**
	 * 设置经度
	 *
	 * @param longitude 经度
	 */
	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}

	/**
	 * 获取维度
	 *
	 * @return LATITUDE - 维度
	 */
	public BigDecimal getLatitude() {
		return latitude;
	}

	/**
	 * 设置维度
	 *
	 * @param latitude 维度
	 */
	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}

	/**
	 * 获取设备对接方式
	 *
	 * @return JOIN_TYPE - 设备对接方式
	 */
	public String getJoinType() {
		return joinType;
	}

	/**
	 * 设置设备对接方式
	 *
	 * @param joinType 设备对接方式
	 */
	public void setJoinType(String joinType) {
		this.joinType = joinType == null ? null : joinType.trim();
	}

	/**
	 * 获取POI名称
	 *
	 * @return POI - POI名称
	 */
	public String getPoi() {
		return poi;
	}

	/**
	 * 设置POI名称
	 *
	 * @param poi POI名称
	 */
	public void setPoi(String poi) {
		this.poi = poi == null ? null : poi.trim();
	}

	/**
	 * 获取POI地址
	 *
	 * @return POI_ADDRESS - POI地址
	 */
	public String getPoiAddress() {
		return poiAddress;
	}

	/**
	 * 设置POI地址
	 *
	 * @param poiAddress POI地址
	 */
	public void setPoiAddress(String poiAddress) {
		this.poiAddress = poiAddress == null ? null : poiAddress.trim();
	}

	/**
	 * 获取是否联网
	 *
	 * @return IS_NET - 是否联网
	 */
	public String getIsNet() {
		return isNet;
	}

	/**
	 * 设置是否联网
	 *
	 * @param isNet 是否联网
	 */
	public void setIsNet(String isNet) {
		this.isNet = isNet == null ? null : isNet.trim();
	}

	/**
	 * 获取屏幕尺寸（单位：英寸）
	 *
	 * @return SIZE - 屏幕尺寸（单位：英寸）
	 */
	public Double getSize() {
		return size;
	}

	/**
	 * 设置屏幕尺寸（单位：英寸）
	 *
	 * @param size 屏幕尺寸（单位：英寸）
	 */
	public void setSize(Double size) {
		this.size = size;
	}

	/**
	 * 获取标签
	 *
	 * @return LABELS - 标签
	 */
	public String getLabels() {
		return labels;
	}

	/**
	 * 设置标签
	 *
	 * @param labels 标签
	 */
	public void setLabels(String labels) {
		this.labels = labels == null ? null : labels.trim();
	}

	/**
	 * @return CRM_CODE
	 */
	public String getCrmCode() {
		return crmCode;
	}

	/**
	 * @param crmCode
	 */
	public void setCrmCode(String crmCode) {
		this.crmCode = crmCode == null ? null : crmCode.trim();
	}

	/**
	 * 获取组合ID，用于一机多主
	 *
	 * @return COMBINED_ID - 组合ID，用于一机多主
	 */
	public Integer getCombinedId() {
		return combinedId;
	}

	/**
	 * 设置组合ID，用于一机多主
	 *
	 * @param combinedId 组合ID，用于一机多主
	 */
	public void setCombinedId(Integer combinedId) {
		this.combinedId = combinedId;
	}

	/**
	 * 获取型号
	 *
	 * @return MODEL - 型号
	 */
	public String getModel() {
		return model;
	}

	/**
	 * 设置型号
	 *
	 * @param model 型号
	 */
	public void setModel(String model) {
		this.model = model == null ? null : model.trim();
	}

	/**
	 * 获取品牌
	 *
	 * @return BRAND - 品牌
	 */
	public String getBrand() {
		return brand;
	}

	/**
	 * 设置品牌
	 *
	 * @param brand 品牌
	 */
	public void setBrand(String brand) {
		this.brand = brand == null ? null : brand.trim();
	}

	/**
	 * 获取屏幕数量
	 *
	 * @return SCREEN_QUANTITY - 屏幕数量
	 */
	public Integer getScreenQuantity() {
		return screenQuantity;
	}

	/**
	 * 设置屏幕数量
	 *
	 * @param screenQuantity 屏幕数量
	 */
	public void setScreenQuantity(Integer screenQuantity) {
		this.screenQuantity = screenQuantity;
	}

	/**
	 * 获取每日接触人数
	 *
	 * @return SEE_NUM - 每日接触人数
	 */
	public Integer getSeeNum() {
		return seeNum;
	}

	/**
	 * 设置每日接触人数
	 *
	 * @param seeNum 每日接触人数
	 */
	public void setSeeNum(Integer seeNum) {
		this.seeNum = seeNum;
	}

	/**
	 * 获取iot物联网通信secret
	 *
	 * @return SECRET - iot物联网通信secret
	 */
	public String getSecret() {
		return secret;
	}

	/**
	 * 设置iot物联网通信secret
	 *
	 * @param secret iot物联网通信secret
	 */
	public void setSecret(String secret) {
		this.secret = secret == null ? null : secret.trim();
	}

	/**
	 * 获取【自动升级版本区分】易信发yxf、中性neu、天使盒子angle_box、金嵘达jrd
	 *
	 * @return APP_TYPE - 【自动升级版本区分】易信发yxf、中性neu、天使盒子angle_box、金嵘达jrd
	 */
	public String getAppType() {
		return appType;
	}

	/**
	 * 设置【自动升级版本区分】易信发yxf、中性neu、天使盒子angle_box、金嵘达jrd
	 *
	 * @param appType 【自动升级版本区分】易信发yxf、中性neu、天使盒子angle_box、金嵘达jrd
	 */
	public void setAppType(String appType) {
		this.appType = appType == null ? null : appType.trim();
	}

	/**
	 * 获取设备播放类型 G/D
	 *
	 * @return PAY_TYPE - 设备播放类型 G/D
	 */
	public String getPayType() {
		return payType;
	}

	/**
	 * 设置设备播放类型 G/D
	 *
	 * @param payType 设备播放类型 G/D
	 */
	public void setPayType(String payType) {
		this.payType = payType == null ? null : payType.trim();
	}

	/**
	 * 获取设备类型名称
	 *
	 * @return DEVICE_TYPE_NAME - 设备类型名称
	 */
	public String getDeviceTypeName() {
		return deviceTypeName;
	}

	/**
	 * 设置设备类型名称
	 *
	 * @param deviceTypeName 设备类型名称
	 */
	public void setDeviceTypeName(String deviceTypeName) {
		this.deviceTypeName = deviceTypeName == null ? null : deviceTypeName.trim();
	}

	/**
	 * 获取心跳时间
	 *
	 * @return HEARTBEAT_TIME - 心跳时间
	 */
	public Date getHeartbeatTime() {
		return heartbeatTime;
	}

	/**
	 * 设置心跳时间
	 *
	 * @param heartbeatTime 心跳时间
	 */
	public void setHeartbeatTime(Date heartbeatTime) {
		this.heartbeatTime = heartbeatTime;
	}

	/**
	 * @return COMMENT
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * @param comment
	 */
	public void setComment(String comment) {
		this.comment = comment == null ? null : comment.trim();
	}

	/**
	 * @return DEVICE_NAME
	 */
	public String getDeviceName() {
		return deviceName;
	}

	/**
	 * @param deviceName
	 */
	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName == null ? null : deviceName.trim();
	}

	/**
	 * 获取结款状态 （1：已付款，2：待付款）
	 *
	 * @return PAYMENT_STATUS - 结款状态 （1：已付款，2：待付款）
	 */
	public Boolean getPaymentStatus() {
		return paymentStatus;
	}

	/**
	 * 设置结款状态 （1：已付款，2：待付款）
	 *
	 * @param paymentStatus 结款状态 （1：已付款，2：待付款）
	 */
	public void setPaymentStatus(Boolean paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	/**
	 * 获取设备单价(分)
	 *
	 * @return DEVICE_PRICE - 设备单价(分)
	 */
	public BigDecimal getDevicePrice() {
		return devicePrice;
	}

	/**
	 * 设置设备单价(分)
	 *
	 * @param devicePrice 设备单价(分)
	 */
	public void setDevicePrice(BigDecimal devicePrice) {
		this.devicePrice = devicePrice;
	}

	/**
	 * @return CREATE_TIME
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * @param createTime
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * @return UPDATE_TIME
	 */
	public Date getUpdateTime() {
		return updateTime;
	}

	/**
	 * @param updateTime
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 * 获取是否可售
	 *
	 * @return IS_SALE - 是否可售
	 */
	public String getIsSale() {
		return isSale;
	}

	/**
	 * 设置是否可售
	 *
	 * @param isSale 是否可售
	 */
	public void setIsSale(String isSale) {
		this.isSale = isSale == null ? null : isSale.trim();
	}

	/**
	 * 获取售卖方式
	 *
	 * @return SALE_TYPE - 售卖方式
	 */
	public String getSaleType() {
		return saleType;
	}

	/**
	 * 设置售卖方式
	 *
	 * @param saleType 售卖方式
	 */
	public void setSaleType(String saleType) {
		this.saleType = saleType == null ? null : saleType.trim();
	}

	/**
	 * 获取百度是否备案；Y-是，N-否
	 *
	 * @return BAIDU_FLAG - 百度是否备案；Y-是，N-否
	 */
	public String getBaiduFlag() {
		return baiduFlag;
	}

	/**
	 * 设置百度是否备案；Y-是，N-否
	 *
	 * @param baiduFlag 百度是否备案；Y-是，N-否
	 */
	public void setBaiduFlag(String baiduFlag) {
		this.baiduFlag = baiduFlag == null ? null : baiduFlag.trim();
	}

	/**
	 * @return ip
	 */
	public String getIp() {
		return ip;
	}

	/**
	 * @param ip
	 */
	public void setIp(String ip) {
		this.ip = ip == null ? null : ip.trim();
	}

	/**
	 * 获取可否程序化投放
	 *
	 * @return auto_serving - 可否程序化投放
	 */
	public String getAutoServing() {
		return autoServing;
	}

	/**
	 * 设置可否程序化投放
	 *
	 * @param autoServing 可否程序化投放
	 */
	public void setAutoServing(String autoServing) {
		this.autoServing = autoServing == null ? null : autoServing.trim();
	}

	/**
	 * 获取是否导入投个屏
	 *
	 * @return import_tgp - 是否导入投个屏
	 */
	public String getImportTgp() {
		return importTgp;
	}

	/**
	 * 设置是否导入投个屏
	 *
	 * @param importTgp 是否导入投个屏
	 */
	public void setImportTgp(String importTgp) {
		this.importTgp = importTgp == null ? null : importTgp.trim();
	}

	/**
	 * 获取投个屏设备状态(Y-启用，N-禁用)
	 *
	 * @return tgp_status - 投个屏设备状态(Y-启用，N-禁用)
	 */
	public String getTgpStatus() {
		return tgpStatus;
	}

	/**
	 * 设置投个屏设备状态(Y-启用，N-禁用)
	 *
	 * @param tgpStatus 投个屏设备状态(Y-启用，N-禁用)
	 */
	public void setTgpStatus(String tgpStatus) {
		this.tgpStatus = tgpStatus == null ? null : tgpStatus.trim();
	}

	/**
	 * 获取投个屏二维码
	 *
	 * @return qrcode - 投个屏二维码
	 */
	public String getQrcode() {
		return qrcode;
	}

	/**
	 * 设置投个屏二维码
	 *
	 * @param qrcode 投个屏二维码
	 */
	public void setQrcode(String qrcode) {
		this.qrcode = qrcode == null ? null : qrcode.trim();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", id=").append(id);
		sb.append(", uniqueId=").append(uniqueId);
		sb.append(", uuid=").append(uuid);
		sb.append(", thirdId=").append(thirdId);
		sb.append(", accountId=").append(accountId);
		sb.append(", deviceTypeId=").append(deviceTypeId);
		sb.append(", groupId=").append(groupId);
		sb.append(", name=").append(name);
		sb.append(", width=").append(width);
		sb.append(", height=").append(height);
		sb.append(", widthCm=").append(widthCm);
		sb.append(", heightCm=").append(heightCm);
		sb.append(", status=").append(status);
		sb.append(", open=").append(open);
		sb.append(", province=").append(province);
		sb.append(", provinceCode=").append(provinceCode);
		sb.append(", city=").append(city);
		sb.append(", cityCode=").append(cityCode);
		sb.append(", district=").append(district);
		sb.append(", districtCode=").append(districtCode);
		sb.append(", address=").append(address);
		sb.append(", longitude=").append(longitude);
		sb.append(", latitude=").append(latitude);
		sb.append(", joinType=").append(joinType);
		sb.append(", poi=").append(poi);
		sb.append(", poiAddress=").append(poiAddress);
		sb.append(", isNet=").append(isNet);
		sb.append(", size=").append(size);
		sb.append(", labels=").append(labels);
		sb.append(", crmCode=").append(crmCode);
		sb.append(", combinedId=").append(combinedId);
		sb.append(", model=").append(model);
		sb.append(", brand=").append(brand);
		sb.append(", screenQuantity=").append(screenQuantity);
		sb.append(", seeNum=").append(seeNum);
		sb.append(", secret=").append(secret);
		sb.append(", appType=").append(appType);
		sb.append(", payType=").append(payType);
		sb.append(", deviceTypeName=").append(deviceTypeName);
		sb.append(", heartbeatTime=").append(heartbeatTime);
		sb.append(", comment=").append(comment);
		sb.append(", deviceName=").append(deviceName);
		sb.append(", paymentStatus=").append(paymentStatus);
		sb.append(", devicePrice=").append(devicePrice);
		sb.append(", createTime=").append(createTime);
		sb.append(", updateTime=").append(updateTime);
		sb.append(", isSale=").append(isSale);
		sb.append(", saleType=").append(saleType);
		sb.append(", baiduFlag=").append(baiduFlag);
		sb.append(", ip=").append(ip);
		sb.append(", autoServing=").append(autoServing);
		sb.append(", importTgp=").append(importTgp);
		sb.append(", tgpStatus=").append(tgpStatus);
		sb.append(", qrcode=").append(qrcode);
		sb.append(", serialVersionUID=").append(serialVersionUID);
		sb.append("]");
		return sb.toString();
	}
}
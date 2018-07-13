package com.dss.ssm.entity;

public class Menu {

	private int mid;
	private String mname;
	private String miconCls;
	private int mparent;
	private String murl;

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getMiconCls() {
		return miconCls;
	}

	public void setMiconCls(String miconCls) {
		this.miconCls = miconCls;
	}

	public int getMparent() {
		return mparent;
	}

	public void setMparent(int mparent) {
		this.mparent = mparent;
	}

	public String getMurl() {
		return murl;
	}

	public void setMurl(String murl) {
		this.murl = murl;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((miconCls == null) ? 0 : miconCls.hashCode());
		result = prime * result + mid;
		result = prime * result + ((mname == null) ? 0 : mname.hashCode());
		result = prime * result + mparent;
		result = prime * result + ((murl == null) ? 0 : murl.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Menu other = (Menu) obj;
		if (miconCls == null) {
			if (other.miconCls != null)
				return false;
		} else if (!miconCls.equals(other.miconCls))
			return false;
		if (mid != other.mid)
			return false;
		if (mname == null) {
			if (other.mname != null)
				return false;
		} else if (!mname.equals(other.mname))
			return false;
		if (mparent != other.mparent)
			return false;
		if (murl == null) {
			if (other.murl != null)
				return false;
		} else if (!murl.equals(other.murl))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Menu [mid=" + mid + ", mname=" + mname + ", miconCls="
				+ miconCls + ", mparent=" + mparent + ", murl=" + murl + "]";
	}

	public Menu(int mid, String mname, String miconCls, int mparent, String murl) {
		super();
		this.mid = mid;
		this.mname = mname;
		this.miconCls = miconCls;
		this.mparent = mparent;
		this.murl = murl;
	}

	public Menu() {
		super();
	}
}

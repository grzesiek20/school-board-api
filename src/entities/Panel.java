package entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


	@Entity
	@Table
	public class Panel implements Serializable {

		
		private static final long serialVersionUID = 1L;

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column
		private int id;
		@Column
		private int height;
		@Column
		private int perWidth;
		//@Basic(optional = true)
		@Column
		private int perLeftMargin;
		@Column
		private int topMargin;
		@Column
		private String bgColor;
		@Column
		private int fontSize;
		@Column
		private String fontColor;
		@Column
		private String header;
		@Column
		private String headerColor;
		@Column
		private String headerFontSize;
		@Column
		private String headerFontColor;
		@Column
		private String textAlign;
		
		
		
		public Panel() {
			super();
		}
		
		public int getId() {
			return id;
		}



		public void setId(int id) {
			this.id = id;
		}



		public int getHeight() {
			return height;
		}



		public void setHeight(int height) {
			this.height = height;
		}



		public int getPerWidth() {
			return perWidth;
		}



		public void setPerWidth(int perWidth) {
			this.perWidth = perWidth;
		}



		public int getPerLeftMargin() {
			return perLeftMargin;
		}



		public void setPerLeftMargin(int perLeftMargin) {
			this.perLeftMargin = perLeftMargin;
		}



		public int getTopMargin() {
			return topMargin;
		}



		public void setTopMargin(int topMargin) {
			this.topMargin = topMargin;
		}



		public String getBgColor() {
			return bgColor;
		}



		public void setBgColor(String bgColor) {
			this.bgColor = bgColor;
		}



		public int getFontSize() {
			return fontSize;
		}



		public void setFontSize(int fontSize) {
			this.fontSize = fontSize;
		}



		public String getFontColor() {
			return fontColor;
		}



		public void setFontColor(String fontColor) {
			this.fontColor = fontColor;
		}



		public String getHeader() {
			return header;
		}



		public void setHeader(String header) {
			this.header = header;
		}



		public String getHeaderColor() {
			return headerColor;
		}



		public void setHeaderColor(String headerColor) {
			this.headerColor = headerColor;
		}



		public String getHeaderFontSize() {
			return headerFontSize;
		}



		public void setHeaderFontSize(String headerFontSize) {
			this.headerFontSize = headerFontSize;
		}



		public String getHeaderFontColor() {
			return headerFontColor;
		}



		public void setHeaderFontColor(String headerFontColor) {
			this.headerFontColor = headerFontColor;
		}



		public String getTextAlign() {
			return textAlign;
		}



		public void setTextAlign(String textAlign) {
			this.textAlign = textAlign;
		}
		
	   
	}

package uicomp;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

	public class POM extends BaseClass {
		
		public POM() {
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(xpath="//input[@name='firstname']")
		private WebElement first;
		
		@FindBy(xpath ="//input[@name='lastname']")
		private WebElement surname;
		
		@FindBy(name="birthday_day")
		private WebElement date;

		public WebElement getFirst() {
			return first;
		}

		public WebElement getDate() {
			return date;
		}

		public void setDate(WebElement date) {
			this.date = date;
		}

		public void setFirst(WebElement first) {
			this.first = first;
		}

		public WebElement getSurname() {
			return surname;
		}

		public void setSurname(WebElement surname) {
			this.surname = surname;
		}

	}
	
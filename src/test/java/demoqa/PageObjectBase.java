package test.java.demoqa;

public abstract class PageObjectBase {
    protected  ISeleniumContext seleniumContext;

    public PageObjectBase(ISeleniumContext context) {
    }

    public ISeleniumContext getSeleniumContext() {
        return seleniumContext;
    }

    public void setSeleniumContext(ISeleniumContext seleniumContext) {
        this.seleniumContext = seleniumContext;
    }


}

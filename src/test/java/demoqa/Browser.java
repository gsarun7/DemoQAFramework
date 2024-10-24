package test.java.demoqa;

public abstract class Browser {

    private  ISeleniumContext seleniumContext;

    public ISeleniumContext getSeleniumContext() {
        return seleniumContext;
    }

    public void setSeleniumContext(ISeleniumContext seleniumContext) {
        this.seleniumContext = seleniumContext;
    }

    public abstract void start(String browserName);
}

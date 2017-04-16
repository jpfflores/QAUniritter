package page;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import run.Driver;

public class FinalizaCompraPage extends MasterPage {
	// Summary 
	private WebElement minus;
	private WebElement plus;
	private WebElement quantidade;
	private WebElement excluir;
	private WebElement checkout;
	
	//Login 
	private WebElement user;
	private WebElement password;
	private WebElement submit;

	// Address
	private WebElement confirma;
	private WebElement novoendereco;
	private WebElement comentario;
	private WebElement submitendereco;
	
	//Shipping
	private WebElement aceite;
	private WebElement termos;
	private WebElement fechatermos;
	private WebElement submitshipping;
	
	// Payment
	private WebElement transferencia;
	private WebElement cheque;
	
	private WebElement confirmtransferencia;
	private WebElement confirmcheque;
	
	private WebElement sucesso;
	
	public FinalizaCompraPage(Driver baseD){
		baseDriver = baseD;
		driver = baseDriver.getDriver();
		wait = new WebDriverWait(driver, 30);
		builder = new Actions(driver);
	}
	
	public void loadSummary(){	
		// Summary
		setCheckout(driver.findElement(By.xpath("//*[@id='center_column']/p[2]/a[1]")));
		setMinus(driver.findElement(By.className("icon-minus")));
		setPlus(driver.findElement(By.className("icon-plus")));
		setExcluir(driver.findElement(By.className("cart_quantity_delete")));
		setCheckout(driver.findElement(By.xpath("//*[@id='center_column']/p[2]/a[1]/span")));
		
	}

	public void loadLogin(){	
		user = driver.findElement(By.id("email"));
		password = driver.findElement(By.id("passwd"));
		submit = driver.findElement(By.id("SubmitLogin"));
	}
	
	public void loadAddressTab(){
		// Address
		setConfirma(driver.findElement(By.id("addressesAreEquals")));
		setNovoEndereco(driver.findElement(By.xpath("//*[@id='center_column']/form/div/p/a/span")));
		comentario = driver.findElement(By.className("form-control"));
		submitendereco = driver.findElement(By.xpath("//*[@id='center_column']/form/p/button/span"));
		
	}
	
	public void loadShippingTab(){
		// Shipping
		aceite = driver.findElement(By.id("cgv"));
		termos = driver.findElement(By.xpath("//*[@id='form']/div/p[2]/a"));
		submitshipping = driver.findElement(By.xpath("//*[@id='form']/p/button"));
		// alert className("fancybox-error")
		//*[@id="form"]/p/button/span
		
	}
	
	public void loadPaymentTab(){
		// Payment
		//pay by transferencia
		transferencia = driver.findElement(By.className("bankwire"));
		// Pay by check
		cheque = driver.findElement(By.className("cheque"));
	}
	
	public void aceitaTermos(){
		By aceite = By.id("cgv");
		wait.until(ExpectedConditions.visibilityOfElementLocated(aceite));
		getAceite().click();
	}
	
	public void pagarTransferencia() {
		builder.moveToElement(getTransferencia()).click().build().perform();
		WebElement confirm = driver.findElement(By.xpath("//*[@id='cart_navigation']/button/span"));
		builder.moveToElement(confirm).click().build().perform();
	}
	
	public void pagarCheque() {
		builder.moveToElement(getCheque()).click().build().perform();
		WebElement confirm = driver.findElement(By.xpath("//*[@id='cart_navigation']/button/span"));
		builder.moveToElement(confirm).click().build().perform();
	}
	
	public Actions getBuilder(){
		return builder;
	}

	public WebDriverWait getWait(){
		return wait;
	}
	
	public WebElement getCheckout() {
		return checkout;
	}
	public void setCheckout(WebElement checkout) {
		this.checkout = checkout;
	}
	public WebElement getExcluir() {
		return excluir;
	}
	public void setExcluir(WebElement excluir) {
		this.excluir = excluir;
	}
	public WebElement getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(WebElement quantidade) {
		this.quantidade = quantidade;
	}
	public WebElement getPlus() {
		return plus;
	}
	public void setPlus(WebElement plus) {
		this.plus = plus;
	}
	public WebElement getMinus() {
		return minus;
	}
	public void setMinus(WebElement minus) {
		this.minus = minus;
	}
	
	public WebElement getUser() {
		return user;
	}
	public void setUser(WebElement user) {
		this.user = user;
	}

	public WebElement getPassword() {
		return password;
	}

	public void setPassword(WebElement password) {
		this.password = password;
	}

	public WebElement getSubmit() {
		return submit;
	}
	
	public void setSubmit(WebElement submit) {
		this.submit = submit;
	}

	public WebElement getConfirma() {
		return confirma;
	}

	public void setConfirma(WebElement confirma) {
		this.confirma = confirma;
	}

	public WebElement getNovoEndereco() {
		return novoendereco;
	}

	public void setNovoEndereco(WebElement endereco) {
		this.novoendereco = endereco;
	}

	public WebElement getComentario() {
		comentario = driver.findElement(By.xpath("//*[@id='ordermsg']/textarea"));
		return comentario;
	}

	public void setComentario(WebElement comentario) {
		this.comentario = comentario;
	}

	public WebElement getSubmitEndereco() {
		submitendereco = driver.findElement(By.xpath("//*[@id='center_column']/form/p/button/span"));
		return submitendereco;
	}

	public WebElement getTermos() {
		return termos;
	}

	public void setTermos(WebElement termos) {
		this.termos = termos;
	}

	public WebElement getFechaTermos() {
		fechatermos = driver.findElement(By.xpath("//*[@id='order']/div[2]/div/div/a"));
		return fechatermos;
	}

	public void setFechaTermos(WebElement termos) {
		this.fechatermos = termos;
	}

	public WebElement getSubmitShipping() {
		submitshipping = driver.findElement(By.xpath("//*[@id='form']/p/button/span"));
		return submitshipping;
	}
	public WebElement getLoginALert() {
		WebElement obj = driver.findElement(By.xpath("//*[@id='center_column']/div[1]/p"));
		return obj;
	}
	
	public WebElement getAceite() {
		aceite = driver.findElement(By.id("cgv"));
		return aceite;
	}
	
	public WebElement getTransferencia() {
		transferencia = driver.findElement(By.className("bankwire"));
		return transferencia;
	}

	public WebElement getCheque() {
		cheque = driver.findElement(By.className("cheque"));
		return cheque;
	}

	public WebElement getConfirmTransferencia(){
		confirmtransferencia = driver.findElement(By.xpath("//*[@id='cart_navigation]/button/span"));
		return confirmtransferencia;
	}

	public WebElement getConfirmCheque(){
		confirmcheque = driver.findElement(By.xpath("//*[@id='cart_navigation]/button/span"));
		return confirmcheque;
	}
	
	public WebElement getSucesso(){
		sucesso = driver.findElement(By.xpath("//*[@id='center_column']/p[1]"));
		return sucesso;
	}

}

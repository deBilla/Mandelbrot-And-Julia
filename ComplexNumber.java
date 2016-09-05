/**
 * Mandelbrot.java
 * Dimuthu Wickramanayake
 * E/13/397
 * 2016.09.03
 */
 
/**This class is cretaed to do the necessary calculation and specially mapping
 * of complex numbers in the fractal class*/
 
public class ComplexNumber
{
	
/**final values of real part and complex part but this can be change inside the 
 * constructor*/	
	private final double real;
	private final double comp;
	
/**Constructor of the complex number this take 2 arguments and return 2 numbers as well*/	
	public ComplexNumber(double real, double comp)
	{
		this.real= real;
		this.comp= comp;
	}
	
/**Addition of complex numbers are done here real part and complex part are 
 * seperatey added and returned*/	
	public ComplexNumber add(ComplexNumber c)
	{
		double real= this.real + c.real;
		double comp= this.comp+ c.comp;
		
		return new ComplexNumber(real, comp);
	}
	
/**Return the square of a complex number (a + bi)^2 = (a^2-b^2)+2abi
 * real part =  (a^2-b^2)
 * complex part = 2ab*/	
	public ComplexNumber square()
	{	
		double real= Math.pow(this.real,2.0) - Math.pow(this.comp,2.0);
		double complex= (2*this.real*this.comp);
		
		return new ComplexNumber(real, complex);
	}
	
/**This method return the magnitude of a complex number. a+bi = (a^2-b^2)^(1/2)*/	
	public double magnitude()
	{	
		return Math.abs(Math.sqrt(this.real*this.real + this.comp*this.comp));
	}
	
/**This method map the canvas with the complex number proportionally. x and y are
 * input arguments taken from fractal which are the coordinates */	
	public ComplexNumber map(double canvasSize, double x, double y)
	{
		double real= (this.real - 1)+ (2* ((x)/canvasSize));
		double comp= (this.comp + 1)- (2* ((y)/canvasSize));
		
		return new ComplexNumber(real, comp);
	}
	
	
	
}

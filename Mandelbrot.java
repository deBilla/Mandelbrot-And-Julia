/**
 * Mandelbrot.java
 * Dimuthu Wickramanayake
 * E/13/397
 * 2016.09.03
 */
import java.awt.*;
import javax.swing.JFrame;

public class Mandelbrot{

/**Global variables which can be used every method*/	
	private JFrame frame;
	private Canvas canvas;

/**Constructor for the mandelbrot class here the frame is made
 * and canvas is inserted in to it*/	
	public Mandelbrot() {
		
		frame = new JFrame("The Mandelbrot Set");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800,800);
		canvas = new Canvas();
		canvas.setSize(800,800);
		frame.add(canvas, BorderLayout.PAGE_START);
		frame.pack();
		frame.setVisible(true);

	}
	
/**This is the method where drawing on the canvas happen*/
	public void draw(double real1,double real2,double imag1,double imag2,double iterationNo)
	{
		Graphics g = canvas.getGraphics(); //graphic object is created
		canvas.paint(g);

/**using the input arguments the radius of the complex and real circles are found*/		
		double realCenter = (real1 - real2)/2;
		double imagCenter = (imag1 - imag2)/2;
		
/**Following loops process each and every pixel in the canvas*/		
		for (int x=0; x<800; x++)
		{
			for (int y=0; y<800; y++)
			{
				
				ComplexNumber z= new ComplexNumber(realCenter,imagCenter); //this is the changing complex number
				z= z.map(800, x, y);

				ComplexNumber c= z; //c is non changing complex number

				int numStepsTaken=0;
				boolean draw= false;

				do
				{	
					z= z.square().add(c); //z = z^2 + c

					if(z.magnitude()>2) //check whether the number is outsie the set
					{
						
/**Colors are set using the constructor for colors which give a bitwise colour*/						
						g.setColor(new Color((int) ((256 << 16) * numStepsTaken / iterationNo))); 
						g.drawLine(x, y, x, y);
						draw=true; //to tell that we have colored the pixel so no need of default color
					}
					numStepsTaken++; //to keep track of number of iteration 

				}while (numStepsTaken<iterationNo && draw==false); //when number of steps is equal to max iterations loop stop

				if (draw==false) //when draw = false then apply the default black color
				{
					g.setColor(Color.BLACK);
					g.drawLine(x, y, x, y);
				}
			}
		}
	}
}


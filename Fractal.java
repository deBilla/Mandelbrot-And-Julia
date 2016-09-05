/**
 * Fractal.java
 * Dimuthu Wickramanayake
 * E/13/397
 * 2016.09.02
 */

/**This is the main class which will link other necessary classes 
 * when implementing*/

public class Fractal{
	
/**This is the main method where necessary fractals are made*/
	public static void main(String[] args) {
		
/**If the commandline argument equal mandelbrot then implement it*/
		if(args[0].equals("Mandelbrot")){
		
			Mandelbrot m = new Mandelbrot();
			try{
				double real1,real2,imag1,imag2,iterations;
/**if argument length is 5 then number of arguments 4 default iteration value is taken as 1000*/				
				if(args.length == 5){
					real1 = Double.parseDouble(args[1]);
					real2 = Double.parseDouble(args[2]);
					imag1 = Double.parseDouble(args[3]);
					imag2 = Double.parseDouble(args[4]);
					iterations = 1000;
/**if argument length is 1 no of arguments 0 then default value is taken as -1,1,-1,1,1000*/						
				}else if(args.length == 1){
					real1 = -1;
					real2 = 1;
					imag1 = -1;
					imag2 = -1;
					iterations = 1000;
/**else take all the input values*/					
				}else{
					real1 = Double.parseDouble(args[1]);
					real2 = Double.parseDouble(args[2]);
					imag1 = Double.parseDouble(args[3]);
					imag2 = Double.parseDouble(args[4]);
					iterations = Double.parseDouble(args[5]);
				}
/**call the draw method which drew the mandelbrot on the canvas*/				
				m.draw(real1,real2,imag1,imag2,iterations);
			}catch(Exception e){
				System.out.println("input arguments for Mandelbrot Set should be of type Double");
				System.exit(1);
			}
/**If the commandline argument equal Julia then implement it*/			
		}else if(args[0].equals("Julia")){
			Julia m = new Julia();
			try{
				
				double real,imag,iterations;
/**if there are no argumnets then give these default values*/ 				
				if(args.length == 1){
					real = -0.4;
					imag = 0.6;
					iterations = 1000;
/**if there are 2 arguments then take no of iteration is default value*/					
				}else if(args.length == 3){
					real = Double.parseDouble(args[1]);
					imag = Double.parseDouble(args[2]);
					iterations = 1000;
/**else take input as it is*/					
				}else{
					real = Double.parseDouble(args[1]);
					imag = Double.parseDouble(args[2]);
					iterations = Double.parseDouble(args[3]);
				}
				m.draw(real,imag,iterations);
/**if there is problem with arguments then catch the exception*/				
			}catch(Exception e){
				System.out.println("input arguments for Julia set should be of type Double");
				System.exit(1);
			}
/**else tell user to Give a correct input*/	
	}else System.out.println("Your commandline argumnet should be java Fractal Mandelbrot number number number number number or java Fractal Julia number number number");
	
}
	
}

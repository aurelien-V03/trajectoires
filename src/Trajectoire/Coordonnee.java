/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Trajectoire;

	public class Coordonnee {

		private double x;
		private double y;
		private double z;
		
		// Constructeur par defaut
		public Coordonnee(){	
			x = 0.0d;
			y = 0.0d;
			z = 0.0d;
		}
		
		public Coordonnee(double x, double y, double z){
			this.set(x,y,z);
		}
		
		public Coordonnee(Coordonnee c)
		{
			this(c.getX(), c.getY(), c.getZ());
		}

		public void setX(double x) {
			this.x = x;
		}

		public void setY(double y) {
			this.y = y;
		}

		public void setZ(double z) {
			this.z = z;
		}

		public double getX() {
			return x;
		}

		public double getY() {
			return y;
		}

		public double getZ() {
			return z;
		}
		
		@Override
		public String toString() {
		return "(" + x + "," + y + "," + z + ")";
		}
		
		public Boolean isEqual(Coordonnee pos) {
			return ((pos.x == x) && (pos.y == y) && (pos.z == z));
			}
		
		public void set(double x, double y , double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	}

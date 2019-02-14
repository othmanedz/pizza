package userManager.service;

public class Pizza {
		static int random=0;
	

		int id;
		String name;
		int price;
		
		public Pizza() {}
		public Pizza(String name,int price) throws IllegalArgumentException{
			if(name==null || name.equals("") || new Integer(price)==null) throw new IllegalArgumentException();
			this.name = name;
			this.price = price;
			this.id=random++;
		}
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getPrice() {
			return price;
		}
		public void setPrice(int price) {
			this.price = price;
		}
		
}

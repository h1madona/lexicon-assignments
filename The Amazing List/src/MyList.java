
public class MyList {
	public static void main(String[] args) {
		AmazingList<Integer> list = new AmazingList<>();
		for(int i=0; i<10; i++) {
			list.add(i);
		}
		
//		for(int i=0; i<list.size(); i++) {
//			System.out.println(list.get(i));
//		}
		
		list.remove(0);
		list.remove(0);
		
		
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}

package basicJavaDemo;

public class DemoTrim {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String oneLine = "  I's was overjoyed's to be able to celebrate one of my favorite authors, Italo Calvino.";

		oneLine = oneLine.replace(" ", "\n");
		oneLine = oneLine.replace(".", "");
		oneLine = oneLine.replace(",", "");
		oneLine = oneLine.replace("'s", "");
		System.out.println(oneLine);
		
		oneLine = oneLine.replace("\n", " ");
		System.out.println("2: " + oneLine.trim());
		
		oneLine = oneLine.concat(", hello world    ").trim();
		System.out.println(oneLine);
		
		oneLine = oneLine.concat(", hello world").trim().toUpperCase();
		System.out.println(oneLine);
		
//				for (int i=0; i<oneLine.length(); i++) {
//					char c = oneLine.charAt(i);
//					
//					if (c == ' ') {
//						System.out.println();
//					} else if (c == '.' || c == ',') {
//						// just do nothing is good
//					} else if (c == '\''){
//						if (oneLine.charAt(i+1) == 's') {	
//						}
//					} else {
//						System.out.print(c);
//					}
//				}
	}

}

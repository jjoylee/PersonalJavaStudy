package reflection;

public class ReflectionTarget {
	
	public int field1;
	protected String field2;
	private int[] field3;
	public double field4;
	private float field5;
	
	public ReflectionTarget(){
	}
	
	private ReflectionTarget(int field1){
		this.field1 = field1;
	}
	
	public ReflectionTarget(String field2, int[] field3){
		this.field2 = field2;
		this.field3 = field3;
	}
	
	private ReflectionTarget(int field1, String field2, int[] field3){
		this(field1);
		this.field2 = field2;
		this.field3 = field3;
	}
	
	public ReflectionTarget(int field1, String field2,int[] field3,double field4){
		this(field1,field2,field3);
		this.field4 = field4;
	}
	
	private int getField1() {
		return field1;
	}

	private void setField1(int field1) {
		this.field1 = field1;
	}

	public String getField2() {
		return field2;
	}

	public void setField2(String field2) {
		this.field2 = field2;
	}

	public int[] getField3() {
		return field3;
	}

	public void setField3(int[] field3) {
		this.field3 = field3;
	}

	private double getField4() {
		return field4;
	}

	private void setField4(double field4) {
		this.field4 = field4;
	}

	public float getField5() {
		return field5;
	}

	public void setField5(float field5) {
		this.field5 = field5;
	}
}

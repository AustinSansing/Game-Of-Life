
public interface ICell extends Runnable {
	boolean is_alive();
	int row();
	int col();
	void update();
	void determine();
	void run();
	
	
	

}

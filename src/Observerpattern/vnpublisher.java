package Observerpattern;

public interface vnpublisher {
	public void add(vnsubcriber o);
	public void remove(vnsubcriber o);
	public void notifyobserver();

}

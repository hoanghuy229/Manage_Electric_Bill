package Observerpattern;

public interface nnpublisher {
	public void add(nnsubcriber o);
	public void remove(nnsubcriber o);
	public void notifyobserver();
}

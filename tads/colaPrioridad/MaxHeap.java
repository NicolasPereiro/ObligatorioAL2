package tads.colaPrioridad;

import tads.Pair;

public class MaxHeap<E, P extends Comparable<P>> implements ColaPrioridad<E, P> {
  /** Pair{K,V}[] */
  private Object[] arr;
  private int elements;

  public MaxHeap(int expectedSize) {
    arr = new Object[expectedSize + 1];
  }

  @Override
  public void push(E elem, P prio) {
    elements++;
    if (elements >= arr.length) {
      Object[] newArr = new Object[arr.length * 2];
      for(int i = 0; i< arr.length; i++){
        newArr[i] = arr[i];
      }
      arr = newArr;
    }
    arr[elements] = new Pair<E, P>(elem, prio);
    siftUp(elements);
  }

  @SuppressWarnings("unchecked")
  private void siftUp(int pos) {
    if (pos == 1) {
      return;
    }
    int parentPos = pos / 2;
    Pair<E, P> curr = (Pair<E, P>) arr[pos];
    Pair<E, P> parent = (Pair<E, P>) arr[parentPos];
    if (curr.snd.compareTo(parent.snd) > 0) {
      swap(pos, parentPos);
      siftUp(parentPos);
    }
  }
  
  @SuppressWarnings("unchecked")
  private void swap(int pos, int parentPos) {
    Pair<E, P> aux = (Pair<E, P>) arr[parentPos];
    arr[parentPos] = arr[pos];
    arr[pos] = aux;
  }

  @Override
  public E pop() {
    E ret = top();
    arr[1] = arr[elements];
    elements--;
    siftDown(1);
    return ret;
  }

  @SuppressWarnings("unchecked")
  private void siftDown(int pos) {
    if(pos*2 > elements)return;
    Pair<E, P> curr = (Pair<E, P>) arr[pos];
    Pair<E, P> child1 = (Pair<E, P>) arr[pos*2];
    Pair<E, P> child2 = (Pair<E, P>) arr[pos*2+1];
    int childPos1 = pos * 2;
    int childPos2 = pos * 2 + 1;
    if(arr[childPos2] == null){
      if(curr.snd.compareTo(child1.snd) > 0){
        swap(pos, childPos1);
      }
    } else if ((child1.snd).compareTo(child2.snd) > 0){
        if(curr.snd.compareTo(child1.snd) < 0){
          swap(pos, childPos1);
          siftDown(childPos1);
        }
    } else if (curr.snd.compareTo(child2.snd) < 0){
      swap(pos, childPos2);
      siftDown(childPos2);
    }
  }

  @Override
  @SuppressWarnings("unchecked")
  public E top() {
    if (size() < 1) {
      throw new RuntimeException("Heap is empty");
    }
    return ((Pair<E, P>) arr[1]).fst;
  }

  @Override
  public int size() {
    return elements;
  }

}
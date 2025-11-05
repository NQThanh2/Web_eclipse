
package nqueen;
import java.util.*;

public class Node
{
    int n; // the number of queens need to be placed
    List<Integer> state; // the current positions of queens
    List<Node> neighbours; 

    public Node(int n)
	{
		this.n = n;
		this.state = new ArrayList<>();
		this.neighbours = new ArrayList<>();
	}

    public Node(int n,List<Integer> state)
	{
		this.n = n;
		this.state = state;
		this.neighbours = new ArrayList<>();
	}

    public void addNeighbours(Node neighbourNode)
	{
		this.neighbours.add(neighbourNode);
	}

    public List<Node> getNeighbours()
    {
        if(this.state.size() == n) return null;

        for(int row = 0; row < this.n; row++)
        {
            List<Integer> newState = this.place(row);
            if(newState != null)
            {
                this.neighbours.add(new Node(this.n, newState));
            }
        }
        return this.neighbours;
    }

    //col == index
    //row == value

    public boolean isValid(List<Integer> state)
    {
            if (state == null || state.isEmpty()) return false;
            if(state.size() == 1) return true;
            if(state.size() > 1)
            {
                int lastRow = state.get(state.size()-1);
                int lastCol = state.size()-1;

                for(int i=0; i<state.size()-1; i++)
                {
                    if(lastRow == state.get(i)) return false;
                    int currentRow = state.get(i);
                    int currentCol = i;
                    if(Math.abs(currentCol-lastCol) == Math.abs(currentRow-lastRow)) return false;
                }
            } 

            return true;
    }

    public List<Integer> place(int x)
    {
        if(this.state != null)
        {
            List<Integer> ans = new ArrayList<>(this.state);
            ans.add(x);
            if(isValid(ans))  return ans;
        }
        return null;
    }


}
class Solution {
    public boolean exist(char[][] board, String word) {
        int row=board.length;
        int col=board[0].length;

        boolean[][] visited=new boolean[row][col];
       
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                if(board[i][j]==word.charAt(0))
                {
                    if(backtrack(board,word,visited,i,j,0))
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public boolean backtrack(char[][] board,String word,boolean[][] visited,int row,int col,int index)
    {
        if(word.length()==index)
        {
            return true;
        }

        if(row<0 || col<0 || row>=board.length || col >= board[0].length || visited[row][col] || board[row][col]!=word.charAt(index))
        {
            return false;
        }

        visited[row][col]=true;

        boolean left=backtrack(board,word,visited,row,col-1,index+1);
        boolean right=backtrack(board,word,visited,row,col+1,index+1);
        boolean top=backtrack(board,word,visited,row-1,col,index+1);
        boolean bottom=backtrack(board,word,visited,row+1,col,index+1);

        if(left || right|| top || bottom)
        {
            return true;
        }
        visited[row][col]=false;
        return false;
    }
}
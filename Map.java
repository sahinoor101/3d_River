class Map
{
    public static void main(String args[])
    {
        int map[][];
        int i,j;
        Map ob=new Map();
        map=ob.getMap();
        for(i=0;i<10;i++)
        {
            for(j=0;j<10;j++)
            {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }
    public int[][] river(int x,int y,int map[][])
    {
        int river[][]=new int[10][10];
        
        return river;
    }
    public int[][] getMap()
    {
        int map[][]=new int [10][10];
        int i,j;
        for(i=0;i<10;i++)
        {
            for(j=0;j<10;j++)
            {
                map[i][j]=(int)((Math.random()*9)+1);
            }
        }
        return map;
    }
}
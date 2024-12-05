class Map
{
    static int river[][]={{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0}};
    public static void main(String args[])
    {
        int map[][]={{3,2,6,3,8,4},{2,3,9,9,5,8},{4,5,7,7,1,5},{7,7,8,9,3,3},{5,7,8,3,4,2},{6,7,3,8,9,6}};
        int i,j;
        Map ob=new Map();
        //map=ob.getMap();
        int river[][];
        river=ob.river(1, 2, map);
        for(i=0;i<map.length;i++)
        {
            for(j=0;j<map[0].length;j++)
            {
                System.out.print(river[i][j]+" ");
            }
            System.out.println();
        }
    }
    public int[][] river(int x,int y,int map[][])
    {
        //int river[][]={{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0}};
        Map ob=new Map();
        char max=ob.max(x+1,x-1,y+1,y-1,map);
        if(max == 'x' )
        {
            return river;
        }
        if(max == 't' && ob.isValid( x, y, map)== true)
        {
            map[x][y]=0;
            river[x][y]=1;
            ob.river(x+1, y, map);
        }
        if(max == 'b'  && ob.isValid( x, y, map)== true)
        {
            map[x][y]=0;
            river[x][y]=1;
            ob.river(x-1, y, map);
        }
        if(max == 'r' && ob.isValid( x, y, map)== true)
        {
            map[x][y]=0;
            river[x][y]=1;
            ob.river(x, y+1, map);
        }
        if(max== 'l' && ob.isValid( x, y, map)== true)
        {
            map[x][y]=0;
            river[x][y]=1;
            ob.river(x, y-1, map);
        }
        return river;
    }
    public char max(int x1,int x2,int y1,int y2,int map[][])
    {
        Map ob=new Map();
        int a,b,c,d;
        if(ob.isValid(x1, y1-1, map)== false)
        {
            a=0;
        }
        else
        {
            a=map[x1][y1-1];
        }
        if(ob.isValid(x2, y1-1, map)== false)
        {
            b=0;
        }
        else
        {
            b=map[x2][y1-1];
        }
        if(ob.isValid(x1-1, y1, map)== false)
        {
            c=0;
        }
        else
        {
            c=map[x1-1][y1];
        }
        if(ob.isValid(x1-1, y2, map)== false)
        {
            d=0;
        }
        else
        {
            d=map[x1-1][y2];
        }
        int max= Math.max(Math.max(a,b),Math.max(c,d));
        if(a == max)
        {
            return 't';
        }
        if(b == max)
        {
            return 'b';
        }
        if(c == max)
        {
            return 'r';
        }
        if(d == max)
        {
            return 'l';
        }
        return 'x';
    }
    public boolean isValid(int x, int y, int map[][]) 
    {
        return !(x < 0 || y < 0 || x >= map.length || y >= map[0].length);
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
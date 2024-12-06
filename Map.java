class Map
{
    public static void main(String args[])
    {
        int map[][]={{3,2,6,3,8,4},{2,3,9,9,5,8},{4,5,7,7,1,5},{7,7,8,9,3,3},{5,7,8,3,4,2},{6,7,3,8,9,6}};
        int i,j;
        Map ob=new Map();
        //map=ob.getMap();
        for(i=0;i<map.length;i++)
        {
            for(j=0;j<map[0].length;j++)
            {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("Source block : ("+1+","+2+")");
        ob.river(1, 2, map);
    }
    public void river(int x,int y,int map[][])
    {
        //int river[][]={{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0}};
        Map ob=new Map();
        if(ob.isValid( x, y, map)== true )
        {
            char ch=ob.max(x+1,x-1,y+1,y-1,map,map[x][y]);
            map[x][y]=0;
            switch (ch) {
                case 'r':
                    ob.river(x, y+1, map);
                    break;
                case 'l':
                    ob.river(x, y-1, map);
                    break;
                case 'b':
                    ob.river(x+1, y, map);
                    break;
                case 't':
                    ob.river(x-1, y, map);
                    break;
                default:
                    break;
            }
        }
    }
    public char max(int x1,int x2,int y1,int y2,int map[][],int n)
    {
        Map ob=new Map();
        int a,b,c,d;
        if(ob.isValid(x1, y1-1, map)== false )
        {
            a=0;
        }
        else if(map[x1][y1-1]<=n)
        {
            a=map[x1][y1-1];
        }
        else
        {
            a=0;
        }
        if(ob.isValid(x2, y1-1, map)== false)
        {
            b=0;
        }
        else if(map[x2][y1-1]<=n)
        {
            b=map[x2][y1-1];
        }
        else
        {
            b=0;
        }
        if(ob.isValid(x1-1, y1, map)== false)
        {
            c=0;
        }
        else if(map[x1-1][y1]<=n)
        {
            c=map[x1-1][y1];
        }else
        {
            c=0;
        }
        if(ob.isValid(x1-1, y2, map)== false)
        {
            d=0;
        }
        else if(map[x1-1][y2]<=n)
        {
            d=map[x1-1][y2];
        }else
        {
            d=0;
        }
        if(a==0 && b==0 && c==0 && d==0)
        {
            return 'x';
        }
        int max= Math.max(Math.max(a,b),Math.max(c,d));
        if(a == max)
        {
            System.out.println("bottom("+x1+","+(y1-1)+")");
            return 'b';
        }
        else if(b == max)
        {
            System.out.println("top("+x2+","+(y1-1)+")");
            return 't';
        }
        else if(c == max)
        {
            System.out.println("Right("+(x1-1)+","+y1+")");
            return 'r';
        }
        else if(d == max)
        {
            System.out.println("Left("+(x1-1)+","+y2+")");
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
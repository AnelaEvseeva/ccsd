import java.net.SocketOption;
import java.util.Scanner;

class Gora{
    String name;
    String location;
    double height;
}

public class Main{
    //методы для всех подзадач
    public static Gora[] setMountainArr(int k){
        Scanner sc=new Scanner(System.in);
        Gora mountain[]=new Gora[k];

        System.out.println("Введите информацию о горах:");
        for(int i=0; i < mountain.length; i++){
            mountain[i]=new Gora();
            System.out.print("Название "+(i+1)+"-й горы: ");
            mountain[i].name=sc.nextLine();
            System.out.print("Расположение "+(i+1)+"-й горы: ");
            mountain[i].location=sc.nextLine();
            System.out.print("Высота "+(i+1)+"-й горы: ");
            mountain[i].height=sc.nextDouble();
            sc.nextLine();
        }
        return mountain;
    }
    public static void showArray(Gora[]mount){
        for(int i = 0; i < mount.length; i++){
            System.out.println(""+mount[i].name+"\t"+mount[i].location+"\t"+mount[i].height+" м.");
        }
    }
    //инф-я об одной горе
    public static void showMountain(Gora mount){
        System.out.println(""+mount.name+"\t"+mount.location+"\t"+mount.height+" м.");
    }
    //самая высокая гора
    public static int NMax(Gora[]h){
        int nmax=0;
        double max=h[nmax].height;
        for(int i = 0; i< h.length; i++)
            if(h[i].height>max){
                max = h[i].height;
                nmax=i;
            }
        return nmax;
    }
    //выше 1000 м.
    public static Gora [] Higher(Gora mount[]){
        int h=1000;
        int kol=0;
        for(int i=0; i< mount.length; i++){
            if(mount[i].height>h)
                ++kol;
        }
        if(kol!=0){
            Gora[]highMountain=new Gora[kol];
            int n=-1;
            for(int i=0;i< mount.length;i++)
                if(mount[i].height>h){
                    highMountain[++n]=mount[i];
                }
            return highMountain;
        }
        else return null;
    }
    //сортировка по возрастанию высот
    public static void sortHeight(Gora[]mount){
        for (int i=0; i< mount.length-1;i++)
            for (int j=0; j< mount.length-1-i; j++)
                if(mount[j].height>mount[j+1].height){
                    Gora r=mount[j];
                    mount[j]=mount[j+1];
                    mount[j+1]=r;
                }
    }
    //поиск по названию
    public static Gora findForName(Gora mount[], String name){
        int n = -1;
        for(int i=0; i < mount.length; i++)
            if(name.equals(mount[i].name))
                n=i;
            if(n!=-1){
                return mount[n];
            }
            else return null;
    }

    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Введите количество гор: ");
        int n=sc.nextInt();
        Gora mountain[]=setMountainArr(n);
        System.out.println("\nХарактеристики гор:");
        showArray(mountain);

        int nmax=NMax(mountain);
        System.out.println("\nСамая высокая вершина:");
        showMountain(mountain[nmax]);

        System.out.println("\nГоры, с вершиной выше 1000 м.:");
        Gora[]larger=Higher(mountain);
        showArray(larger);

        sortHeight(mountain);
        System.out.println("\nСортировка гор по высоте:");
        showArray(mountain);

        System.out.println("\nПоиск по названию \nВведите название горы:");
        sc.nextLine();
        String gname=sc.nextLine();
        Gora gfind=findForName(mountain, gname);
        if(gfind!=null){
            showMountain(gfind);
        }
        else{
            System.out.println("Такой горы нет в списке!");
        }
    }
}
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.ArrayList;
public class Diet {
    public static void main(String[] args) {
        System.out.println("Inserisci il file di input: ");
        File f = new File(new Scanner(System.in).nextLine());
        try{
            //input dei dati
            Scanner in = new Scanner(f);
            int n = Integer.parseInt(in.nextLine()); //numero di panini
            int[] pesi = new int[n];
            int i =0;
            while(in.hasNext())
            {
                pesi[i] = (Integer.parseInt(in.next()));//riempio l'array con i pesi
                i++;
            }
            in.close();

            //elaborazione
            int[] w= new int[n]; //pesi ottimali
            int[] pos = new int[n]; //posizioni pesi che identificano percorso migliore
            for(i=0; i<n; i++)
                pos[i] = -1;

            for(i=n-1; i>=0; i--)
            {
                w[i] = pesi[i];
                for(int j=i+1; j<n; j++)
                {
                    if(pesi[j]>pesi[i])
                        continue;
                    if(w[j]+pesi[i]>w[i])
                    {
                        w[i] = w[j]+pesi[i];
                        pos[i] = j;
                    }
                }
            }

            int idx =0;
            for(i=0; i<n; i++)
                if(w[i] > w[idx])
                    idx =i;
            ArrayList<Integer> out = new ArrayList<>();
            while(idx != -1)
            {
                out.add(0, pesi[idx]);
                idx = pos[idx];
            }
            //output
            System.out.println(out.size());
            System.out.println(out.toString());
                
        }
        catch(FileNotFoundException ex)
        {
            System.out.println("File non trovato");
        }
    }
}

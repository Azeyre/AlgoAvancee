package tp06;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class OccurenceTexte {

	public static void main(String[] args){
		//String s = "oui je la la oUi Bonjour ha la bonjoureee haha oui haha oui haha hihi lolz";
		//System.out.println(getOccurence(s));
		File file = new File("res/VICTOR_HUGO-Notre_dame_de_paris.txt");
		String text = fileToString(file);
		afficherTopValue(getOccurence(text));
	}

	public static String fileToString(File file) {
		String s = "";
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String st = "";
			while((st = br.readLine()) != null){
				s += " " + st;
			}
		} catch (IOException e){
			return null;
		}
		return s;
	}

	public static Map<String, Integer> getOccurence(String s){
		if(s == null || s.isEmpty()) throw new IllegalStateException();

		Map<String, Integer> occ = new HashMap<>();
		String[] mots = s.split("\\W+");
		for(int i = 0 ; i < mots.length ; i++){
			if(occ.containsKey(mots[i].toLowerCase()))
				occ.put(mots[i].toLowerCase(), occ.get(mots[i].toLowerCase()) + 1);
			 else occ.put(mots[i].toLowerCase(), 1);
		}
		return occ;
	}

    private static void afficherTopValue(Map<String, Integer> hm)
    {
    	if(hm.size() <= 5) return;

        String[] tab = new String[]{"","","","",""};
        int[] valueTab = new int[]{0,0,0,0,0};

        int value;
        String temp;
        int tempValue;
        for(String s: hm.keySet()){
        	value = hm.get(s);
        	if(value > valueTab[0]){
        		valueTab[0] = value;
        		tab[0] = s;
        		int i = 1;
        		while(i < 5 && value > valueTab[i]){
        			tempValue = valueTab[i];
        			temp = tab[i];
        			tab[i] = s;
        			valueTab[i] = value;
        			tab[i - 1] = temp;
        			valueTab[i - 1] = tempValue;
        			i++;
        		}
        	}
        }

        for(int i = 0 ; i < 5 ; i++){
        	System.out.println(tab[i] + " = " + valueTab[i]);
        }
    }

}
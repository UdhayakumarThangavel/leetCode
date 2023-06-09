import java.util.HashMap;

class Solution {

    public int makeConnected(int n, int[][] connections) {
        int notConnected = 0;
        int extraCable = 0;
        for (int i=1;i<n ;i++
             ) {
            int count=0;
            for (int[] con: connections
                 ) {
                if(i==con[1]){
                    count +=1;
                }
            }
            if(count==0){
                notConnected += 1;
            } else if(count>1){
                extraCable += (count-1);
            }
        }
        System.out.println(notConnected);
        System.out.println(extraCable);
        if(extraCable>=notConnected){
            return notConnected;
        }
        return -1;
    }

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(flowerbed.length==1){
            if(flowerbed[0]==0){
                flowerbed[0]= 1;
                n--;
            }
        } else if (flowerbed.length==2) {
            if(flowerbed[0]==0 && flowerbed[1]==0){
                flowerbed[0]= 1;
                n--;
            }
        } else{
            for (int i=0;i< flowerbed.length;i++){
                if(i==0){
                    if(flowerbed[i]==0 && flowerbed[i+1]==0){
                        flowerbed[i]= 1;
                        n--;
                        System.out.println("yes"+n);
                    }
                } else if (i==flowerbed.length-1)  {
                    if(flowerbed[i]==0 && flowerbed[i-1]==0){
                        flowerbed[i] = 1;
                        n--;
                    }
                }else if(flowerbed[i]==0){
                    if(flowerbed[i+1]==0 && flowerbed[i-1]==0){
                        flowerbed[i]=1;
                        n--;
                    }
                }
            }
        }
        if(n<1){
            return true;
        }
        return false;
    }
    public boolean isValid(String s) {
        String[] array = s.split("");
        int[] count = {0,0,0,0,0,0};
        if(array.length%2==0){
            for (String value: array
            ) {
                if(value.equals("(")){
                    count[0] += 1;
                } else if (value.equals(")")) {
                    count[1] += 1;
                } else if (value.equals("{")) {
                    count[2] += 1;
                } else if (value.equals("}")) {
                    count[3] += 1;
                } else if (value.equals("[")) {
                    count[4] += 1;
                } else if (value.equals("]")) {
                    count[5] += 1;
                }
            }
            if(count[0]==count[1] && count[2]==count[3] && count[4]==count[5]){
                return true;
            }
        }
        return false;
    }
    public boolean temp2isValid(String s) {
        String[] array = s.split("");
        boolean isValid = false;
        boolean isNotValid = false;
        if(array.length%2==0){
            for (int i=0;i< array.length && !isNotValid ;i++){
                if(array[i].equals("(")){
                    boolean temp = false;
                    for (int j=i+1;j<array.length;j++){
                        if(array[j].equals(")")){
                            temp = true;
                        }
                    }
                    if(temp){
                        isValid = true;
                    }else {
                        isValid = false;
                        isNotValid = true;
                    }
                } else if (array[i].equals("{")) {
                    boolean temp = false;
                    for (int j=i+1;j<array.length;j++){
                        if(array[j].equals("}")){
                            temp = true;
                        }
                    }
                    if(temp){
                        isValid = true;
                    }else {
                        isValid = false;
                        isNotValid = true;
                    }
                } else if (array[i].equals("[")) {
                    boolean temp = false;
                    for (int j=i+1;j<array.length;j++){
                        if(array[j].equals("]")){
                            temp = true;
                        }
                    }
                    if(temp){
                        isValid = true;
                    }else {
                        isValid = false;
                        isNotValid = true;
                    }
                }

            }
        }
        return isValid;
    }

    public boolean tempIsValid(String s) {
        String[] array = s.split("");
        boolean isValid = false;
        boolean isNotValid = false;
        if(array.length%2==0){
            for (int i=0;i< array.length && !isNotValid ;i++){
                if(array[i].equals("(") && array[i+1].equals(")")){
                    isValid = true;
                    i++;
                } else if (array[i].equals("{") && array[i+1].equals("}")) {
                    isValid = true;
                    i++;
                } else if (array[i].equals("[") && array[i+1].equals("]")) {
                    isValid = true;
                    i++;
                } else {
                    isValid = false;
                    isNotValid = true;
                    i++;
                }
            }
        }
        return isValid;
    }
    public String longestCommonPrefix(String[] strs) {
        String commonPrefix="";
        String[] array = strs[0].split("");
        for (int i=0;i< array.length;i++
        ) {
            String tempCommonPrefix = "";
            int count = 0;
            for (int j=0;j< strs.length;j++
            ) {
                String[] tempArray = strs[j].split("");
                if(tempArray.length>i){
                    if(tempArray[i].equals(array[i])){
                        tempCommonPrefix = tempArray[i];
                        count+=1;
                    }
                }
            }
            if(count== strs.length){
                commonPrefix += tempCommonPrefix;
            }else {
                i = array.length;
            }
        }
        return commonPrefix;
    }
    public String templongestCommonPrefix(String[] strs) {
        String commonPrefix="";
        String[] array = strs[0].split("");
        for (String s : array) {
            int count = 0;
            String tempCommonPrefix="";
            for (String v:strs
            ) {
                if (v.contains(commonPrefix + s)) {
                    tempCommonPrefix = commonPrefix + s;
                    count+=1;
                }
            }
            if(count==strs.length){
                commonPrefix = tempCommonPrefix;

            }
        }
        return commonPrefix;
    }
    public int romanToInt(String s) {
        HashMap<String,Integer> values = new HashMap<>(){{
            put("I",1);
            put("V",5);
            put("X",10);
            put("L",50);
            put("C",100);
            put("D",500);
            put("M",1000);
        }};
        String[] array = s.split("");
        int result = 0;
        for (int i=0;i<array.length;i++){
            if(array[i].equals("I")){
                if(i+1<array.length){
                    if (array[i+1].equals("V")){
                        result += values.get("V") - values.get("I");
                        i++;
                    } else if (array[i+1].equals("X")) {
                        result += values.get("X") - values.get("I");
                        i++;
                    }else {
                        result += values.get("I");
                    }
                }else {
                    result += values.get("I");
                }
            } else if (array[i].equals("V")) {
                result += values.get("V");
            } else if (array[i].equals("X")) {
                if(i+1<array.length){
                    if (array[i+1].equals("L")){
                        result += values.get("L") - values.get("X");
                        i++;
                    } else if (array[i+1].equals("C")) {
                        result += values.get("C") -values.get("X");
                        i++;
                    }else {
                        result += values.get("X");
                    }
                }else {
                    result += values.get("X");
                }
            } else if (array[i].equals("L")) {
                result += values.get("L");
            } else if (array[i].equals("C")) {
                if(i+1<array.length){
                    if (array[i+1].equals("D")){
                        result += values.get("D") -values.get("C");
                        i++;
                    } else if (array[i+1].equals("M")) {
                        result += values.get("M")-values.get("C");
                        i++;
                    }else {
                        result += values.get("C");
                    }
                }else {
                    result += values.get("C");
                }
            } else if (array[i].equals("D")) {
                result += values.get("D");
            } else if (array[i].equals("M")) {
                result += values.get("M");
            }
        }
        return result;
    }
    public boolean isPalindrome(int x) {
        boolean result = false;
        String[] arryx = String.valueOf(x).split("");
        for(int i=0;i< arryx.length;i++){
            if(arryx[i].equals(arryx[arryx.length-i-1])){
                result = true;
            }else{
                return false;
            }

        }
        return result;
    }
}
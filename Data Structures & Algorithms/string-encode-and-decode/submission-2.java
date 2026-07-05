class Solution {

    public String encode(List<String> strs) {
        StringBuilder builder = new StringBuilder();
        for (String s : strs) {
            builder.append(s.length());
            builder.append("#");
            builder.append(s);
        }

        return builder.toString();
    }

    public List<String> decode(String str) {
        List<String> output = new ArrayList<String>();
        int strLen = 0;
        for (int i = 0; i < str.length();) {
            int j = i + 1;
            for (; j < str.length(); j++) {
                if (str.charAt(j) == '#') {
                    strLen = Integer.parseInt(str.substring(i, j));
                    break;
                }
            }
            
            if (strLen == 0) {
                output.add("");
                i += 2;
                continue;
            }

            output.add(str.substring(j+1, j+1+strLen));
            i = j + strLen + 1;
        }

        return output;
    }
}

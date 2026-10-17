class Solution {

    public String encode(List<String> strs) {
        List<String> strLen = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        for (String str : strs) {
            builder.append(str);
            strLen.add(Integer.toString(str.length()));
        }

        builder.append("#").append(String.join(",", strLen));

        return builder.toString();

    }

    public List<String> decode(String str) {
        int lengthIndex = str.length() - 1;
        while(str.charAt(lengthIndex) != '#') {
            lengthIndex--;
        }
        if (lengthIndex + 1 == str.length()) {
            return new ArrayList<>();
        }

        String lengthStr = str.substring(lengthIndex + 1);
        String[] lengthStrs = lengthStr.split(",");
        int[] lengths = new int[lengthStrs.length];
        Arrays.setAll(lengths, i -> Integer.parseInt(lengthStrs[i]));

        int trackingIndex = 0;
        List<String> result = new ArrayList<>();
        for (int length : lengths) {
            if (length == 0) {
                result.add("");
                continue;
            }
            result.add(str.substring(trackingIndex, trackingIndex + length));
            trackingIndex += length;
        }

        return result;
    }
}

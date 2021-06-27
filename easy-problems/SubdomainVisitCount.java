


class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {

        HashMap<String, Integer> domainToCountMap = new HashMap<>();
        for (String currentString : cpdomains) {
            int visitedCount = Integer.parseInt(currentString.split(" ")[0]);
            String fullDomain = currentString.split(" ")[1];
            domainToCountMap.put(fullDomain, domainToCountMap.getOrDefault(fullDomain, 0) + visitedCount);

            for (int i = 0; i < fullDomain.length(); i++) {
                if (fullDomain.charAt(i) == '.') {
                    String subStringToInsert = fullDomain.substring(i + 1, fullDomain.length());
                    domainToCountMap.put(subStringToInsert, domainToCountMap.getOrDefault(subStringToInsert, 0) + visitedCount);
                }
            }
        }
        List<String> output = new ArrayList<String>();

        for (Map.Entry<String, Integer> currentEntry : domainToCountMap.entrySet()) {
            output.add(currentEntry.getValue() + " " + currentEntry.getKey());
        }

        return output;
    }
}
class Solution {
    public String simplifyPath(String path) {
        if (path.length() == 0)
            return path;


        String[] commands = path.split("/");
        Stack<String> auxSpace = new Stack<>();
        for (int i = 0; i < commands.length; i++) {

            String currentCommand = commands[i];
            if (currentCommand.equals("."))
                continue;
            else if (currentCommand.equals("..") && !auxSpace.isEmpty()) {
                auxSpace.pop();
                continue;
            } else if (currentCommand.length() != 0) {
                auxSpace.push(currentCommand);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("/");
        while (!auxSpace.isEmpty()) {
            sb.append(auxSpace.pop());
            sb.append("/");
        }


        return sb.toString();

    }
}
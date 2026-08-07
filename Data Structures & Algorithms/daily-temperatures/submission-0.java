class Solution {
    class Pair {
        int index;
        int value;

        Pair(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }
    public int[] dailyTemperatures(int[] temperatures) {
        int[] arr = new int[temperatures.length];
        // for(int i=0;i<temperatures.length;i++){
        //     for(int j=i+1;j<temperatures.length;j++){
        //         if(temperatures[i]<temperatures[j]){
        //             arr[i]=j-i;
        //             break;
        //         }
        //         if(j==temperatures.length-1){
        //             arr[i]=0;
        //         }
        //     }
        // }
        Stack<Pair> stack = new Stack<>();

        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > stack.peek().value) {
                Pair p = stack.pop();

                arr[p.index] = i - p.index;
            }

            stack.push(new Pair(i, temperatures[i]));
        }

        return arr;
    }
}

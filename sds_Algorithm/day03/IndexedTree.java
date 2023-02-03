package sds_Algorithm.day03;

//탐색,합,차,곱,빈도수,최대값,최소값 등등
public class IndexedTree {
    static int N,M,K;
    static long[] nums = {1,2,3,4,5};
    static long[] tree;
    static int S;
    public static void main(String[] args) {
        N = 5;
        S = 1;
        while( S < N){
            S = S*2;
        }
        //while문이 끝나면 5개를 커버할 수 있는 수인 8이 나온다.  //leaf의 size 8개
        tree = new long[S * 2];
    }

    public void init(){
        //leaf는 data로로
        for(int i=0; i<N; i++){
            tree[S+i] = nums[i];
        }
        //내부노드는 자식의 합
        for(int i=S-1; i>0; i--){
            tree[i] = tree[i*2] + tree[i*2+1];
        }
    }

    static long query(int left, int right, int node, int queryLeft, int queryRight){
        //1. 연관 없음.
        if(queryRight<left || queryLeft> right){
            return 0; //상관없는, 영향을 안 미치는 값.
        }
        //2. 판단 가능(쏙 들어옴) //유의미하다.
        else if(queryLeft <= left && right <= queryRight){
            return tree[node];
        }
        //3. 판단 불가 - 걸쳐 있음(자식에 의지)
        else{
            int mid = (left+right)/2;
            long leftResult = query(left,mid,node*2,queryLeft,queryRight); //왼쪽 재귀 호출
            long rightResult = query(mid+1, right, node*2+1,queryLeft,queryRight);

            return leftResult+rightResult;
        }
    }

    static void update(int left, int right, int node, int target, int diff){
        //1. 연관 없음.
        if(target < left|| right < target){
            return;
        }
        //2. 연관 있음.(내부노드냐, leaf냐로 나뉜다.)
        else{
            //현재 tree의 diff값 연산을 해줘야 함.
            tree[node] += diff;
            if(left!=right) { //리프노드가 아닌 중간 노드 일때
                int mid = (left+right)/2;
                update(left, mid, node*2 , target,diff); //재귀
                update(mid+1, right, node*2+1, target, diff);//재귀
            }
        }
    }

    //-------------------bottom-up 방식---------------------//
    static long queryBU(int queryLeft, int queryRight){
        long sum = 0;
        int left = S + queryLeft-1; //-1 해줘야 함 주의
        int right = S + queryRight-1;

        while(left <= right){ //둘이 같아도 while문은 돌아야 한다. 둘 중 하나가 먹고 뒤집히면서 끝난다.
            if(left % 2 == 1){ //left경계가 홀수인 상황.
                sum += tree[left++]; //걸린거 사용하고 left값 한 개 옮긴다.
            }
            if(right % 2 ==0){
                sum += tree[right--];
            }
            left/= 2;
            right/=2;
        }
        return sum;
    }

    static void updateBU(int target, int value){
        int node = S + target -1;
        tree[node] = value;
        node /= 2; //부모의 노드로 이동
        while(node>0){ //루트에 도달 할 때까지
            tree[node] = tree[node*2] + tree[node*2 +1];
            node /= 2;
        }
    }
}

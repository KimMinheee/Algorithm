package baekjoon.p22860_폴더정리;

import java.util.*;
import java.io.*;

/**
 * 풀다가 헷갈렸던 것
 * - 재귀로 푸는거까진 ok, 폴더명을 리스트나 hashMap으로 따로 두어야 할지, main을 재귀로 타고 가야될지
 */
/*
테스트케이스
4 7
main folderA 1
main folderB 1
main file1 0
folderB file1 0
folderB file2 0
folderB folderC 1
folderB folderD 1
folderC file3 0
folderC file4 0
folderD file1 0
folderD file6 0
4
main
main/folderB
main/folderB/folderC
main/folderA

결과
5 7
5 6
2 2
0 0
 */
public class Main {
    static int N, M; //폴더개수, 파일개수
    static Folder main;
    static StringBuilder sb = new StringBuilder();
    public static void findAndAdd(String parent, String child, int isFolder){
        if(isFolder == 1){
            //폴더의 위치를 찾고 세팅하는 함수
            if(parent.equals("main")) { //main의 하위 디렉토리
                main.addFolder(new Folder(child));
            }
            else{
                //상위 디렉터리가 main이 아닌 경우 - bfs로 탐색
                //main의 folders 리스트 -> bfs로 탐색 하나씩 탐색 -> 없으면 그 다음 depth
                Queue<Folder> que = new LinkedList<>();
                que.add(main);

                while(!que.isEmpty()){
                    int len = que.size();
                    Folder folder = que.poll();
                    if(folder.name.equals(parent)){
                        folder.addFolder(new Folder(child)); //자식 폴더 추가
                        break;
                    }

                    for(int i=0; i<len; i++){
                        for(int j=0; j<folder.folders.size(); j++){
                            que.add(folder.folders.get(j));
                        }
                    }
                }
            }
        }
        else{
            //파일의 위치를 찾고 저장하는 함수
            if(parent.equals("main")){
                main.addFile(new File(child));
            }
            else{
                Queue<Folder> que2 = new LinkedList<>();
                que2.add(main);

                while(!que2.isEmpty()){
                    int len = que2.size();
                    Folder folder = que2.poll();
                    if(folder.name.equals(parent)){
                        //파일 저장.
                        folder.addFile(new File(child));
                        break;
                    }

                    for(int i=0; i<len; i++){
                        for(int j=0; j<folder.folders.size(); j++){
                            que2.add(folder.folders.get(j));
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        main = new Folder("main"); //root 폴더
        List<String> tmp = new ArrayList<>();

        //폴더, 파일 세팅
        for(int i=0; i<N+M ; i++){
            st = new StringTokenizer(br.readLine());
            String parent = st.nextToken();
            String child = st.nextToken();
            int isFolder = Integer.parseInt(st.nextToken()); //"1" -> child가 folder, "0" -> child가 file
            if(isFolder == 1){ //폴더 먼저 세팅해야 파일을 넣을 수 있다.
                findAndAdd(parent,child,isFolder);
            }
            else{
                tmp.add(parent+" "+child+" "+isFolder);
            }
        }
        //파일 세팅
        for(int i=0; i<tmp.size(); i++){
            String[] tmpList = tmp.get(i).split(" ");
            findAndAdd(tmpList[0],tmpList[1],0);
        }


        //쿼리문
        int queryCnt = Integer.parseInt(br.readLine()); //4번
        for(int q=0; q<queryCnt; q++){
            String[] queryPaths = br.readLine().split("/");

            int depth = 1;
            //System.out.println(Arrays.toString(queryPaths));
            findFolder(queryPaths, depth, main, false); //특정 폴더 찾기 및 개수 구하기
        }
        System.out.print(sb.toString());
    }

    //폴더 찾기
    static void findFolder(String[] queryPaths, int depth, Folder folder, boolean isFinish)
    {
        if(isFinish) return;//flag

        if(depth == queryPaths.length){
            if(queryPaths[depth-1].equals(folder.name)){
                isFinish = true;
                int[] answer = getAnswer(folder,new HashSet<String>(),0);
                sb.append(answer[0]+" "+answer[1]+"\n");
                return;
            }
            return;
        }

            for(int j=0; j<folder.folders.size(); j++){
                //해당 폴더의 하위 폴더의 개수 만큼 반복
                if(!isFinish){
                    findFolder(queryPaths, depth+1, folder.folders.get(j),false);
                }
            }

    }

    //특정 폴더의 하위에 있는 모든 파일의 종류와 개수 구하기
    static int[] getAnswer(Folder folder, HashSet<String> hashSet, int counts){
        int totalCounts = 0;

        //하위 디렉터리 먼저 탐색
        for(int i=0; i<folder.folders.size(); i++){
            int[] tmp =  getAnswer(folder.folders.get(i), hashSet, counts);
            //totalTypes += tmp[0];
            totalCounts += tmp[1];
        }

        //파일 카운트
        for(String key : folder.files.keySet()){
            //totalTypes += 1;
            hashSet.add(key);
            totalCounts += folder.files.get(key);
        }

        int[] answer = {hashSet.size(),totalCounts};
        return answer;
    }
}

class File{
    String name;
    public File(String name){
        this.name = name;
    }
}

class Folder{
    String name;
    HashMap<String,Integer> files;
    List<Folder> folders;
    public Folder(String name){
        this.name = name;
        files = new HashMap<>();
        folders = new ArrayList<>();
    }
    public void addFile(File file){
        if(files.containsKey(file.name)){
            files.put(file.name,files.get(file.name)+1);
        }
        else files.put(file.name,1); //기존에 없다면 1
    }

    public void addFolder(Folder folder){
        folders.add(folder);
    }


}

package baekjoon.p22860_폴더정리;

import java.util.*;
import java.io.*;

public class Main {
    static int N,M,Q; //폴더의 총 개수, 파일의 총 개수, 쿼리의 개수
    static HashMap<String,Folder> folderMap = new HashMap<>();
    static StringBuilder answersb = new StringBuilder();
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        //main 폴더 미리 생성 후 저장
        Folder main = new Folder("main");
        folderMap.put(main.name, main);

        //파일 정보 넣어놓는 리스트
        List<String> tmpFiles = new ArrayList<>();

        for(int i=0; i<N+M; i++){
            st = new StringTokenizer(br.readLine());
            String parent = st.nextToken();
            String child = st.nextToken();
            int isFolder = Integer.parseInt(st.nextToken());

            //파일은 폴더 정보 먼저 세팅한 후에 한다.
            if(isFolder == 0) {
                StringBuilder sb = new StringBuilder();
                sb.append(parent+" "+child+" "+isFolder);
                tmpFiles.add(sb.toString());
            }
            else{//폴더 정보(isFolder  == 1)

                //child가 map에 없다면 넣어준다.
                if(!folderMap.containsKey(child)){
                    folderMap.put(child, new Folder(child));
                }
                //parent가 map에 없다면 넣어준다.
                if(!folderMap.containsKey(parent)){
                    folderMap.put(parent, new Folder(parent));
                }
                //parent의 하위에 child를 넣어준다. //todo: 여기 객체 달라지나 확인
                folderMap.get(parent).addFolder(new Folder(child));
            }
        }

        //파일 세팅
        for(int i=0; i<tmpFiles.size(); i++){
            st = new StringTokenizer(tmpFiles.get(i));
            String parent = st.nextToken();
            String child = st.nextToken();
            int isFolder = Integer.parseInt(st.nextToken());

            folderMap.get(parent).addFile(child);
        }

        //쿼리 구하기
        Q = Integer.parseInt(br.readLine());
        for(int q = 0; q<Q; q++){
            String[] tmp = br.readLine().split("/");
            String findFolder = tmp[tmp.length -1];
            HashMap<String,Integer> answer =findAnswer(findFolder, new HashMap<String,Integer>());
            //여기가 이상함
            answersb.append(answer.keySet().size()+" "+answer.values().stream().mapToInt(Integer::intValue).sum());
            answersb.append("\n");
        }

        System.out.print(answersb.toString());
        br.close();

    }

    //파일 개수 탐색 함수
    public static HashMap<String,Integer> findAnswer(String folder, HashMap<String,Integer> files){
        //파일 탐색
        for(String fileKey : folderMap.get(folder).files){
            if(files.containsKey(fileKey)) files.put(fileKey,files.get(fileKey)+1);
            else files.put(fileKey,1);
        }

        //하위 폴더 탐색
        for(String key : folderMap.get(folder).folders.keySet()){
            findAnswer(key,files);
        }
        return files;
    }

}
class Folder{ //폴더 클래스
    HashMap<String, Folder> folders; //하위 폴더
    HashSet<String> files; //해당 폴더 내의 파일들(파일명 중복 x)
    String name;
    public Folder(String name){
        this.name = name;
        folders  = new HashMap<>();
        files = new HashSet<>();
    }
    public void addFolder(Folder folder){
        this.folders.put(folder.name,folder);
    }
    public void addFile(String fileName){
        this.files.add(fileName);
    }
}
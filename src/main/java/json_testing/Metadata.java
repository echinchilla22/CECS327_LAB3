package json_testing;

import java.util.*;
//import javax.json.JsonObject;
//import javax.json.JsonArray;
//import javax.json.Json;

class Chunk //Page is a chunk
{
        Long guid;
        Long length; //size

    public Chunk(Long length, Long guid){
        this.length = length;
        this.guid = guid;
    }

    public Long getGuid(){
        return guid;
    }
}

class MetaFile
{
        String name;
        Long  length;
        List<Chunk> chunks;

        public MetaFile (String name, Long length){
            this.name = name;
            this.length = length;
            chunks = new ArrayList<Chunk>();
        }

        public String getName(){
          return name;
        }

        public void setName(String name){
          this.name = name;
        }

        public Long getLength(){
          return length;
        }

        public void setLength(Long length){
          this.length = length;
        }

        public List<Chunk> getChunkList(){
          return chunks;
        }

        public void addChunk(Chunk c){
          this.chunks.add(c);
        }


        public Long getPage(int page){
            return chunks.get(page).getGuid();
        }

        public int getNumOfPages(){
            return chunks.size();
        }



        //TODO: return JsonArray
        public void createJsonChunks(){
              for(Chunk c : chunks) {
                  //TODO
                  //c.createJson();
              }
        }
}

class Metadata
{
      List<MetaFile>  metafiles;
      //JsonObject toJsonObject;    // Create a Json Object that contains the file
      //void readFromJsonObject(JsonObject m);  // Read from a Json Object that contains the files
      //JsonArray array = Json.createArrayBuilder().build();


      public void createJson(MetaFile file){
        //this.toJsonObject = Json.createObjectBuilder().build();

        for(int i= 0; i < metafiles.size(); i++){
          file = metafiles.get(i);
          //JsonObject j = createJson(file.createJsonChunks());

        }

        //toJsonObject.put("metadata", metafiles);

      }

      public Metadata(){
          metafiles = new ArrayList<MetaFile>();

      }


      public void addFile(String name, Long length){
        MetaFile metafile = new MetaFile(name, length);
        this.metafiles.add(metafile);

      }

      public String getListOfNames(){
          String names = "";
          for(MetaFile f : metafiles)
            names += f.getName() + "\t" + f.getLength() + "\t" + f.getNumOfPages() +"\n";

          return names;
      }

      public Long getChunk(String fileName, int page){
          for(MetaFile f : metafiles){
              if(f.getName().equals(fileName)){
                  return f.getPage(page);
              }
          }
          return 0L;//TODO: exception
      }

      public Long getHead(String fileName){
          return getChunk(fileName, 0);
      }

      //TODO: getTail

      //TODO: mv rename metafile

      //append
      public void addChunkToFile(String fileName, Long length, Long guid){

          for(MetaFile f : metafiles){
          if(f.getName().equals(fileName)){
              Chunk c = new Chunk(length, guid);
              f.addChunk(c);
              f.setLength(f.getLength() + length);
          }
        }
      }
}

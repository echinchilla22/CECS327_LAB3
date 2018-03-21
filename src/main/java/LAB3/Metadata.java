package LAB3;

import java.util.*;
import javax.json.JsonObject;
import javax.json.JsonArray;
import javax.json.Json;

class Chunk //Page is a chunk
{
        Long guid;
        Long length; //size
}

class MetaFile
{
        String name;
        Long  length;
        List<Chunk> chunks;

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
      JsonObject toJsonObject;    // Create a Json Object that contains the file
      //void readFromJsonObject(JsonObject m);  // Read from a Json Object that contains the files
      JsonArray array = Json.createArrayBuilder().build();


      public void createJson(MetaFile file){
        //this.toJsonObject = Json.createObjectBuilder().build();

        for(int i= 0; i < metafiles.size(); i++){
          file = metafiles.get(i);
          //JsonObject j = createJson(file.createJsonChunks());

        }

        //toJsonObject.put("metadata", metafiles);

      }

      public void addFile(String name, Long length){
        MetaFile metafile = new MetaFile();
        metafile.setName(name);
        metafile.setLength(length);
        this.metafiles.add(metafile);

      }

      public void addChunkToFile(Chunk chunk, String fileName){
        for(int i = 0; i < metafiles.size(); i++){
          if(metafiles.get(i).getName().equals(fileName)){
            metafiles.get(i).addChunk(chunk);
          }
        }
      }
}

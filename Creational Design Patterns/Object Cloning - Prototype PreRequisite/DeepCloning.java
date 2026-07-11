    import java.util.*;

    class A implements Cloneable{
        String text;

        @Override
        public A clone(){
            try{
                return (A) super.clone(); // Immutables Copied with Reference / Primitives free from reference
            } 
            catch(CloneNotSupportedException e){
                throw new RuntimeException(e);
            }
        }
    }

    class B implements Cloneable {
        int number;
        List<String> list;

        @Override
        public B clone(){
            try{
                B clonedB = (B) super.clone();
                if(this.list != null){
                    clonedB.list = new ArrayList<>(this.list); // New data for Mutable references
                }
                return clonedB;
            } 
            catch(CloneNotSupportedException e) {
                throw new RuntimeException(e);
            }
        }
    }

package org.example.postGetExample;

import java.util.List;
import javax.annotation.Generated;
import com.linkedin.data.DataMap;
import com.linkedin.data.schema.PathSpec;
import com.linkedin.data.schema.RecordDataSchema;
import com.linkedin.data.template.DataTemplateUtil;
import com.linkedin.data.template.GetMode;
import com.linkedin.data.template.RecordTemplate;
import com.linkedin.data.template.SetMode;
import com.linkedin.data.template.StringMap;


/**
 * PostGetExample to store data in a list and retrieve it
 * 
 */
@Generated(value = "com.linkedin.pegasus.generator.PegasusDataTemplateGenerator", comments = "LinkedIn Data Template. Generated from /Users/juleskreutzer/Documents/github/JavaRestfullFrameworks/Restli/fortunes/fortunes-api/src/main/pegasus/org/example/postGetExample/PostGetExample.pdsc.", date = "Fri Feb 05 11:01:34 CET 2016")
public class PostGetExample
    extends RecordTemplate
{

    private final static PostGetExample.Fields _fields = new PostGetExample.Fields();
    private final static RecordDataSchema SCHEMA = ((RecordDataSchema) DataTemplateUtil.parseSchema("{\"type\":\"record\",\"name\":\"PostGetExample\",\"namespace\":\"org.example.postGetExample\",\"doc\":\"PostGetExample to store data in a list and retrieve it\",\"fields\":[{\"name\":\"name\",\"type\":{\"type\":\"map\",\"values\":\"string\"},\"doc\":\"An example 'message' field of type string\"}]}"));
    private final static RecordDataSchema.Field FIELD_Name = SCHEMA.getField("name");

    public PostGetExample() {
        super(new DataMap(), SCHEMA);
    }

    public PostGetExample(DataMap data) {
        super(data, SCHEMA);
    }

    public static PostGetExample.Fields fields() {
        return _fields;
    }

    /**
     * Existence checker for name
     * 
     * @see Fields#name
     */
    public boolean hasName() {
        return contains(FIELD_Name);
    }

    /**
     * Remover for name
     * 
     * @see Fields#name
     */
    public void removeName() {
        remove(FIELD_Name);
    }

    /**
     * Getter for name
     * 
     * @see Fields#name
     */
    public StringMap getName(GetMode mode) {
        return obtainWrapped(FIELD_Name, StringMap.class, mode);
    }

    /**
     * Getter for name
     * 
     * @see Fields#name
     */
    public StringMap getName() {
        return getName(GetMode.STRICT);
    }

    /**
     * Setter for name
     * 
     * @see Fields#name
     */
    public PostGetExample setName(StringMap value, SetMode mode) {
        putWrapped(FIELD_Name, StringMap.class, value, mode);
        return this;
    }

    /**
     * Setter for name
     * 
     * @see Fields#name
     */
    public PostGetExample setName(StringMap value) {
        putWrapped(FIELD_Name, StringMap.class, value, SetMode.DISALLOW_NULL);
        return this;
    }

    @Override
    public PostGetExample clone()
        throws CloneNotSupportedException
    {
        return ((PostGetExample) super.clone());
    }

    @Override
    public PostGetExample copy()
        throws CloneNotSupportedException
    {
        return ((PostGetExample) super.copy());
    }

    public static class Fields
        extends PathSpec
    {


        public Fields(List<String> path, String name) {
            super(path, name);
        }

        public Fields() {
            super();
        }

        /**
         * An example 'message' field of type string
         * 
         */
        public PathSpec name() {
            return new PathSpec(getPathComponents(), "name");
        }

    }

}

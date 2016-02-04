
package org.example.fortunes;

import java.util.List;
import javax.annotation.Generated;
import com.linkedin.data.DataMap;
import com.linkedin.data.schema.PathSpec;
import com.linkedin.data.schema.RecordDataSchema;
import com.linkedin.data.template.DataTemplateUtil;
import com.linkedin.data.template.GetMode;
import com.linkedin.data.template.RecordTemplate;
import com.linkedin.data.template.SetMode;


/**
 * Fortune data schema
 * 
 */
@Generated(value = "com.linkedin.pegasus.generator.PegasusDataTemplateGenerator", comments = "LinkedIn Data Template. Generated from /Users/juleskreutzer/Documents/github/JavaRestfullFrameworks/Restli/fortunes/fortunes-api/src/main/pegasus/org/example/fortunes/Fortune.pdsc.", date = "Thu Feb 04 22:12:03 CET 2016")
public class Fortune
    extends RecordTemplate
{

    private final static Fortune.Fields _fields = new Fortune.Fields();
    private final static RecordDataSchema SCHEMA = ((RecordDataSchema) DataTemplateUtil.parseSchema("{\"type\":\"record\",\"name\":\"Fortune\",\"namespace\":\"org.example.fortunes\",\"doc\":\"Fortune data schema\",\"fields\":[{\"name\":\"message\",\"type\":\"string\",\"doc\":\"An example 'message' field of type string\"}]}"));
    private final static RecordDataSchema.Field FIELD_Message = SCHEMA.getField("message");

    public Fortune() {
        super(new DataMap(), SCHEMA);
    }

    public Fortune(DataMap data) {
        super(data, SCHEMA);
    }

    public static Fortune.Fields fields() {
        return _fields;
    }

    /**
     * Existence checker for message
     * 
     * @see Fields#message
     */
    public boolean hasMessage() {
        return contains(FIELD_Message);
    }

    /**
     * Remover for message
     * 
     * @see Fields#message
     */
    public void removeMessage() {
        remove(FIELD_Message);
    }

    /**
     * Getter for message
     * 
     * @see Fields#message
     */
    public String getMessage(GetMode mode) {
        return obtainDirect(FIELD_Message, String.class, mode);
    }

    /**
     * Getter for message
     * 
     * @see Fields#message
     */
    public String getMessage() {
        return getMessage(GetMode.STRICT);
    }

    /**
     * Setter for message
     * 
     * @see Fields#message
     */
    public Fortune setMessage(String value, SetMode mode) {
        putDirect(FIELD_Message, String.class, String.class, value, mode);
        return this;
    }

    /**
     * Setter for message
     * 
     * @see Fields#message
     */
    public Fortune setMessage(String value) {
        putDirect(FIELD_Message, String.class, String.class, value, SetMode.DISALLOW_NULL);
        return this;
    }

    @Override
    public Fortune clone()
        throws CloneNotSupportedException
    {
        return ((Fortune) super.clone());
    }

    @Override
    public Fortune copy()
        throws CloneNotSupportedException
    {
        return ((Fortune) super.copy());
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
        public PathSpec message() {
            return new PathSpec(getPathComponents(), "message");
        }

    }

}

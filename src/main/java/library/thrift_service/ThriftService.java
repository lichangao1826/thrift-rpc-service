package library.thrift_service;

/**
 * Autogenerated by Thrift Compiler (0.11.0)
 *
 * <p>DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *
 * @generated
 */
@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(
    value = "Autogenerated by Thrift Compiler (0.11.0)",
    date = "2019-07-24")
public class ThriftService {

  public interface Iface {

    public String call(String body) throws org.apache.thrift.TException;
  }

  public interface AsyncIface {

    public void call(String body, org.apache.thrift.async.AsyncMethodCallback<String> resultHandler)
        throws org.apache.thrift.TException;
  }

  public static class Client extends org.apache.thrift.TServiceClient implements Iface {
    public static class Factory implements org.apache.thrift.TServiceClientFactory<Client> {
      public Factory() {}

      public Client getClient(org.apache.thrift.protocol.TProtocol prot) {
        return new Client(prot);
      }

      public Client getClient(
          org.apache.thrift.protocol.TProtocol iprot, org.apache.thrift.protocol.TProtocol oprot) {
        return new Client(iprot, oprot);
      }
    }

    public Client(org.apache.thrift.protocol.TProtocol prot) {
      super(prot, prot);
    }

    public Client(
        org.apache.thrift.protocol.TProtocol iprot, org.apache.thrift.protocol.TProtocol oprot) {
      super(iprot, oprot);
    }

    public String call(String body) throws org.apache.thrift.TException {
      send_call(body);
      return recv_call();
    }

    public void send_call(String body) throws org.apache.thrift.TException {
      call_args args = new call_args();
      args.setBody(body);
      sendBase("call", args);
    }

    public String recv_call() throws org.apache.thrift.TException {
      call_result result = new call_result();
      receiveBase(result, "call");
      if (result.isSetSuccess()) {
        return result.success;
      }
      throw new org.apache.thrift.TApplicationException(
          org.apache.thrift.TApplicationException.MISSING_RESULT, "call failed: unknown result");
    }
  }

  public static class AsyncClient extends org.apache.thrift.async.TAsyncClient
      implements AsyncIface {
    public static class Factory
        implements org.apache.thrift.async.TAsyncClientFactory<AsyncClient> {
      private org.apache.thrift.async.TAsyncClientManager clientManager;
      private org.apache.thrift.protocol.TProtocolFactory protocolFactory;

      public Factory(
          org.apache.thrift.async.TAsyncClientManager clientManager,
          org.apache.thrift.protocol.TProtocolFactory protocolFactory) {
        this.clientManager = clientManager;
        this.protocolFactory = protocolFactory;
      }

      public AsyncClient getAsyncClient(
          org.apache.thrift.transport.TNonblockingTransport transport) {
        return new AsyncClient(protocolFactory, clientManager, transport);
      }
    }

    public AsyncClient(
        org.apache.thrift.protocol.TProtocolFactory protocolFactory,
        org.apache.thrift.async.TAsyncClientManager clientManager,
        org.apache.thrift.transport.TNonblockingTransport transport) {
      super(protocolFactory, clientManager, transport);
    }

    public void call(String body, org.apache.thrift.async.AsyncMethodCallback<String> resultHandler)
        throws org.apache.thrift.TException {
      checkReady();
      call_call method_call =
          new call_call(body, resultHandler, this, ___protocolFactory, ___transport);
      this.___currentMethod = method_call;
      ___manager.call(method_call);
    }

    public static class call_call extends org.apache.thrift.async.TAsyncMethodCall<String> {
      private String body;

      public call_call(
          String body,
          org.apache.thrift.async.AsyncMethodCallback<String> resultHandler,
          org.apache.thrift.async.TAsyncClient client,
          org.apache.thrift.protocol.TProtocolFactory protocolFactory,
          org.apache.thrift.transport.TNonblockingTransport transport)
          throws org.apache.thrift.TException {
        super(client, protocolFactory, transport, resultHandler, false);
        this.body = body;
      }

      public void write_args(org.apache.thrift.protocol.TProtocol prot)
          throws org.apache.thrift.TException {
        prot.writeMessageBegin(
            new org.apache.thrift.protocol.TMessage(
                "call", org.apache.thrift.protocol.TMessageType.CALL, 0));
        call_args args = new call_args();
        args.setBody(body);
        args.write(prot);
        prot.writeMessageEnd();
      }

      public String getResult() throws org.apache.thrift.TException {
        if (getState() != State.RESPONSE_READ) {
          throw new IllegalStateException("Method call not finished!");
        }
        org.apache.thrift.transport.TMemoryInputTransport memoryTransport =
            new org.apache.thrift.transport.TMemoryInputTransport(getFrameBuffer().array());
        org.apache.thrift.protocol.TProtocol prot =
            client.getProtocolFactory().getProtocol(memoryTransport);
        return (new Client(prot)).recv_call();
      }
    }
  }

  public static class Processor<I extends Iface> extends org.apache.thrift.TBaseProcessor<I>
      implements org.apache.thrift.TProcessor {
    private static final org.slf4j.Logger _LOGGER =
        org.slf4j.LoggerFactory.getLogger(Processor.class.getName());

    public Processor(I iface) {
      super(
          iface,
          getProcessMap(
              new java.util.HashMap<
                  String,
                  org.apache.thrift.ProcessFunction<I, ? extends org.apache.thrift.TBase>>()));
    }

    protected Processor(
        I iface,
        java.util.Map<
                String, org.apache.thrift.ProcessFunction<I, ? extends org.apache.thrift.TBase>>
            processMap) {
      super(iface, getProcessMap(processMap));
    }

    private static <I extends Iface>
        java.util.Map<
                String, org.apache.thrift.ProcessFunction<I, ? extends org.apache.thrift.TBase>>
            getProcessMap(
                java.util.Map<
                        String,
                        org.apache.thrift.ProcessFunction<I, ? extends org.apache.thrift.TBase>>
                    processMap) {
      processMap.put("call", new call());
      return processMap;
    }

    public static class call<I extends Iface>
        extends org.apache.thrift.ProcessFunction<I, call_args> {
      public call() {
        super("call");
      }

      public call_args getEmptyArgsInstance() {
        return new call_args();
      }

      protected boolean isOneway() {
        return false;
      }

      @Override
      protected boolean handleRuntimeExceptions() {
        return false;
      }

      public call_result getResult(I iface, call_args args) throws org.apache.thrift.TException {
        call_result result = new call_result();
        result.success = iface.call(args.body);
        return result;
      }
    }
  }

  public static class AsyncProcessor<I extends AsyncIface>
      extends org.apache.thrift.TBaseAsyncProcessor<I> {
    private static final org.slf4j.Logger _LOGGER =
        org.slf4j.LoggerFactory.getLogger(AsyncProcessor.class.getName());

    public AsyncProcessor(I iface) {
      super(
          iface,
          getProcessMap(
              new java.util.HashMap<
                  String,
                  org.apache.thrift.AsyncProcessFunction<
                      I, ? extends org.apache.thrift.TBase, ?>>()));
    }

    protected AsyncProcessor(
        I iface,
        java.util.Map<
                String,
                org.apache.thrift.AsyncProcessFunction<I, ? extends org.apache.thrift.TBase, ?>>
            processMap) {
      super(iface, getProcessMap(processMap));
    }

    private static <I extends AsyncIface>
        java.util.Map<
                String,
                org.apache.thrift.AsyncProcessFunction<I, ? extends org.apache.thrift.TBase, ?>>
            getProcessMap(
                java.util.Map<
                        String,
                        org.apache.thrift.AsyncProcessFunction<
                            I, ? extends org.apache.thrift.TBase, ?>>
                    processMap) {
      processMap.put("call", new call());
      return processMap;
    }

    public static class call<I extends AsyncIface>
        extends org.apache.thrift.AsyncProcessFunction<I, call_args, String> {
      public call() {
        super("call");
      }

      public call_args getEmptyArgsInstance() {
        return new call_args();
      }

      public org.apache.thrift.async.AsyncMethodCallback<String> getResultHandler(
          final org.apache.thrift.server.AbstractNonblockingServer.AsyncFrameBuffer fb,
          final int seqid) {
        final org.apache.thrift.AsyncProcessFunction fcall = this;
        return new org.apache.thrift.async.AsyncMethodCallback<String>() {
          public void onComplete(String o) {
            call_result result = new call_result();
            result.success = o;
            try {
              fcall.sendResponse(fb, result, org.apache.thrift.protocol.TMessageType.REPLY, seqid);
            } catch (org.apache.thrift.transport.TTransportException e) {
              _LOGGER.error("TTransportException writing to internal frame buffer", e);
              fb.close();
            } catch (Exception e) {
              _LOGGER.error("Exception writing to internal frame buffer", e);
              onError(e);
            }
          }

          public void onError(Exception e) {
            byte msgType = org.apache.thrift.protocol.TMessageType.REPLY;
            org.apache.thrift.TSerializable msg;
            call_result result = new call_result();
            if (e instanceof org.apache.thrift.transport.TTransportException) {
              _LOGGER.error("TTransportException inside handler", e);
              fb.close();
              return;
            } else if (e instanceof org.apache.thrift.TApplicationException) {
              _LOGGER.error("TApplicationException inside handler", e);
              msgType = org.apache.thrift.protocol.TMessageType.EXCEPTION;
              msg = (org.apache.thrift.TApplicationException) e;
            } else {
              _LOGGER.error("Exception inside handler", e);
              msgType = org.apache.thrift.protocol.TMessageType.EXCEPTION;
              msg =
                  new org.apache.thrift.TApplicationException(
                      org.apache.thrift.TApplicationException.INTERNAL_ERROR, e.getMessage());
            }
            try {
              fcall.sendResponse(fb, msg, msgType, seqid);
            } catch (Exception ex) {
              _LOGGER.error("Exception writing to internal frame buffer", ex);
              fb.close();
            }
          }
        };
      }

      protected boolean isOneway() {
        return false;
      }

      public void start(
          I iface,
          call_args args,
          org.apache.thrift.async.AsyncMethodCallback<String> resultHandler)
          throws org.apache.thrift.TException {
        iface.call(args.body, resultHandler);
      }
    }
  }

  public static class call_args
      implements org.apache.thrift.TBase<call_args, call_args._Fields>,
          java.io.Serializable,
          Cloneable,
          Comparable<call_args> {
    private static final org.apache.thrift.protocol.TStruct STRUCT_DESC =
        new org.apache.thrift.protocol.TStruct("call_args");

    private static final org.apache.thrift.protocol.TField BODY_FIELD_DESC =
        new org.apache.thrift.protocol.TField(
            "body", org.apache.thrift.protocol.TType.STRING, (short) 1);

    private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY =
        new call_argsStandardSchemeFactory();
    private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY =
        new call_argsTupleSchemeFactory();

    public String body; // required

    /**
     * The set of fields this struct contains, along with convenience methods for finding and
     * manipulating them.
     */
    public enum _Fields implements org.apache.thrift.TFieldIdEnum {
      BODY((short) 1, "body");

      private static final java.util.Map<String, _Fields> byName =
          new java.util.HashMap<String, _Fields>();

      static {
        for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
          byName.put(field.getFieldName(), field);
        }
      }

      /** Find the _Fields constant that matches fieldId, or null if its not found. */
      public static _Fields findByThriftId(int fieldId) {
        switch (fieldId) {
          case 1: // BODY
            return BODY;
          default:
            return null;
        }
      }

      /**
       * Find the _Fields constant that matches fieldId, throwing an exception if it is not found.
       */
      public static _Fields findByThriftIdOrThrow(int fieldId) {
        _Fields fields = findByThriftId(fieldId);
        if (fields == null)
          throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
        return fields;
      }

      /** Find the _Fields constant that matches name, or null if its not found. */
      public static _Fields findByName(String name) {
        return byName.get(name);
      }

      private final short _thriftId;
      private final String _fieldName;

      _Fields(short thriftId, String fieldName) {
        _thriftId = thriftId;
        _fieldName = fieldName;
      }

      public short getThriftFieldId() {
        return _thriftId;
      }

      public String getFieldName() {
        return _fieldName;
      }
    }

    // isset id assignments
    public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData>
        metaDataMap;

    static {
      java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap =
          new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
      tmpMap.put(
          _Fields.BODY,
          new org.apache.thrift.meta_data.FieldMetaData(
              "body",
              org.apache.thrift.TFieldRequirementType.DEFAULT,
              new org.apache.thrift.meta_data.FieldValueMetaData(
                  org.apache.thrift.protocol.TType.STRING)));
      metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
      org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(call_args.class, metaDataMap);
    }

    public call_args() {}

    public call_args(String body) {
      this();
      this.body = body;
    }

    /** Performs a deep copy on <i>other</i>. */
    public call_args(call_args other) {
      if (other.isSetBody()) {
        this.body = other.body;
      }
    }

    public call_args deepCopy() {
      return new call_args(this);
    }

    @Override
    public void clear() {
      this.body = null;
    }

    public String getBody() {
      return this.body;
    }

    public call_args setBody(String body) {
      this.body = body;
      return this;
    }

    public void unsetBody() {
      this.body = null;
    }

    /** Returns true if field body is set (has been assigned a value) and false otherwise */
    public boolean isSetBody() {
      return this.body != null;
    }

    public void setBodyIsSet(boolean value) {
      if (!value) {
        this.body = null;
      }
    }

    public void setFieldValue(_Fields field, Object value) {
      switch (field) {
        case BODY:
          if (value == null) {
            unsetBody();
          } else {
            setBody((String) value);
          }
          break;
      }
    }

    public Object getFieldValue(_Fields field) {
      switch (field) {
        case BODY:
          return getBody();
      }
      throw new IllegalStateException();
    }

    /**
     * Returns true if field corresponding to fieldID is set (has been assigned a value) and false
     * otherwise
     */
    public boolean isSet(_Fields field) {
      if (field == null) {
        throw new IllegalArgumentException();
      }

      switch (field) {
        case BODY:
          return isSetBody();
      }
      throw new IllegalStateException();
    }

    @Override
    public boolean equals(Object that) {
      if (that == null) return false;
      if (that instanceof call_args) return this.equals((call_args) that);
      return false;
    }

    public boolean equals(call_args that) {
      if (that == null) return false;
      if (this == that) return true;

      boolean this_present_body = true && this.isSetBody();
      boolean that_present_body = true && that.isSetBody();
      if (this_present_body || that_present_body) {
        if (!(this_present_body && that_present_body)) return false;
        if (!this.body.equals(that.body)) return false;
      }

      return true;
    }

    @Override
    public int hashCode() {
      int hashCode = 1;

      hashCode = hashCode * 8191 + ((isSetBody()) ? 131071 : 524287);
      if (isSetBody()) hashCode = hashCode * 8191 + body.hashCode();

      return hashCode;
    }

    @Override
    public int compareTo(call_args other) {
      if (!getClass().equals(other.getClass())) {
        return getClass().getName().compareTo(other.getClass().getName());
      }

      int lastComparison = 0;

      lastComparison = Boolean.valueOf(isSetBody()).compareTo(other.isSetBody());
      if (lastComparison != 0) {
        return lastComparison;
      }
      if (isSetBody()) {
        lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.body, other.body);
        if (lastComparison != 0) {
          return lastComparison;
        }
      }
      return 0;
    }

    public _Fields fieldForId(int fieldId) {
      return _Fields.findByThriftId(fieldId);
    }

    public void read(org.apache.thrift.protocol.TProtocol iprot)
        throws org.apache.thrift.TException {
      scheme(iprot).read(iprot, this);
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot)
        throws org.apache.thrift.TException {
      scheme(oprot).write(oprot, this);
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder("call_args(");
      boolean first = true;

      sb.append("body:");
      if (this.body == null) {
        sb.append("null");
      } else {
        sb.append(this.body);
      }
      first = false;
      sb.append(")");
      return sb.toString();
    }

    public void validate() throws org.apache.thrift.TException {
      // check for required fields
      // check for sub-struct validity
    }

    private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
      try {
        write(
            new org.apache.thrift.protocol.TCompactProtocol(
                new org.apache.thrift.transport.TIOStreamTransport(out)));
      } catch (org.apache.thrift.TException te) {
        throw new java.io.IOException(te);
      }
    }

    private void readObject(java.io.ObjectInputStream in)
        throws java.io.IOException, ClassNotFoundException {
      try {
        read(
            new org.apache.thrift.protocol.TCompactProtocol(
                new org.apache.thrift.transport.TIOStreamTransport(in)));
      } catch (org.apache.thrift.TException te) {
        throw new java.io.IOException(te);
      }
    }

    private static class call_argsStandardSchemeFactory
        implements org.apache.thrift.scheme.SchemeFactory {
      public call_argsStandardScheme getScheme() {
        return new call_argsStandardScheme();
      }
    }

    private static class call_argsStandardScheme
        extends org.apache.thrift.scheme.StandardScheme<call_args> {

      public void read(org.apache.thrift.protocol.TProtocol iprot, call_args struct)
          throws org.apache.thrift.TException {
        org.apache.thrift.protocol.TField schemeField;
        iprot.readStructBegin();
        while (true) {
          schemeField = iprot.readFieldBegin();
          if (schemeField.type == org.apache.thrift.protocol.TType.STOP) {
            break;
          }
          switch (schemeField.id) {
            case 1: // BODY
              if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
                struct.body = iprot.readString();
                struct.setBodyIsSet(true);
              } else {
                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
              }
              break;
            default:
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
          }
          iprot.readFieldEnd();
        }
        iprot.readStructEnd();

        // check for required fields of primitive type, which can't be checked in the
        // validate method
        struct.validate();
      }

      public void write(org.apache.thrift.protocol.TProtocol oprot, call_args struct)
          throws org.apache.thrift.TException {
        struct.validate();

        oprot.writeStructBegin(STRUCT_DESC);
        if (struct.body != null) {
          oprot.writeFieldBegin(BODY_FIELD_DESC);
          oprot.writeString(struct.body);
          oprot.writeFieldEnd();
        }
        oprot.writeFieldStop();
        oprot.writeStructEnd();
      }
    }

    private static class call_argsTupleSchemeFactory
        implements org.apache.thrift.scheme.SchemeFactory {
      public call_argsTupleScheme getScheme() {
        return new call_argsTupleScheme();
      }
    }

    private static class call_argsTupleScheme
        extends org.apache.thrift.scheme.TupleScheme<call_args> {

      @Override
      public void write(org.apache.thrift.protocol.TProtocol prot, call_args struct)
          throws org.apache.thrift.TException {
        org.apache.thrift.protocol.TTupleProtocol oprot =
            (org.apache.thrift.protocol.TTupleProtocol) prot;
        java.util.BitSet optionals = new java.util.BitSet();
        if (struct.isSetBody()) {
          optionals.set(0);
        }
        oprot.writeBitSet(optionals, 1);
        if (struct.isSetBody()) {
          oprot.writeString(struct.body);
        }
      }

      @Override
      public void read(org.apache.thrift.protocol.TProtocol prot, call_args struct)
          throws org.apache.thrift.TException {
        org.apache.thrift.protocol.TTupleProtocol iprot =
            (org.apache.thrift.protocol.TTupleProtocol) prot;
        java.util.BitSet incoming = iprot.readBitSet(1);
        if (incoming.get(0)) {
          struct.body = iprot.readString();
          struct.setBodyIsSet(true);
        }
      }
    }

    private static <S extends org.apache.thrift.scheme.IScheme> S scheme(
        org.apache.thrift.protocol.TProtocol proto) {
      return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme())
              ? STANDARD_SCHEME_FACTORY
              : TUPLE_SCHEME_FACTORY)
          .getScheme();
    }
  }

  public static class call_result
      implements org.apache.thrift.TBase<call_result, call_result._Fields>,
          java.io.Serializable,
          Cloneable,
          Comparable<call_result> {
    private static final org.apache.thrift.protocol.TStruct STRUCT_DESC =
        new org.apache.thrift.protocol.TStruct("call_result");

    private static final org.apache.thrift.protocol.TField SUCCESS_FIELD_DESC =
        new org.apache.thrift.protocol.TField(
            "success", org.apache.thrift.protocol.TType.STRING, (short) 0);

    private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY =
        new call_resultStandardSchemeFactory();
    private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY =
        new call_resultTupleSchemeFactory();

    public String success; // required

    /**
     * The set of fields this struct contains, along with convenience methods for finding and
     * manipulating them.
     */
    public enum _Fields implements org.apache.thrift.TFieldIdEnum {
      SUCCESS((short) 0, "success");

      private static final java.util.Map<String, _Fields> byName =
          new java.util.HashMap<String, _Fields>();

      static {
        for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
          byName.put(field.getFieldName(), field);
        }
      }

      /** Find the _Fields constant that matches fieldId, or null if its not found. */
      public static _Fields findByThriftId(int fieldId) {
        switch (fieldId) {
          case 0: // SUCCESS
            return SUCCESS;
          default:
            return null;
        }
      }

      /**
       * Find the _Fields constant that matches fieldId, throwing an exception if it is not found.
       */
      public static _Fields findByThriftIdOrThrow(int fieldId) {
        _Fields fields = findByThriftId(fieldId);
        if (fields == null)
          throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
        return fields;
      }

      /** Find the _Fields constant that matches name, or null if its not found. */
      public static _Fields findByName(String name) {
        return byName.get(name);
      }

      private final short _thriftId;
      private final String _fieldName;

      _Fields(short thriftId, String fieldName) {
        _thriftId = thriftId;
        _fieldName = fieldName;
      }

      public short getThriftFieldId() {
        return _thriftId;
      }

      public String getFieldName() {
        return _fieldName;
      }
    }

    // isset id assignments
    public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData>
        metaDataMap;

    static {
      java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap =
          new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
      tmpMap.put(
          _Fields.SUCCESS,
          new org.apache.thrift.meta_data.FieldMetaData(
              "success",
              org.apache.thrift.TFieldRequirementType.DEFAULT,
              new org.apache.thrift.meta_data.FieldValueMetaData(
                  org.apache.thrift.protocol.TType.STRING)));
      metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
      org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(
          call_result.class, metaDataMap);
    }

    public call_result() {}

    public call_result(String success) {
      this();
      this.success = success;
    }

    /** Performs a deep copy on <i>other</i>. */
    public call_result(call_result other) {
      if (other.isSetSuccess()) {
        this.success = other.success;
      }
    }

    public call_result deepCopy() {
      return new call_result(this);
    }

    @Override
    public void clear() {
      this.success = null;
    }

    public String getSuccess() {
      return this.success;
    }

    public call_result setSuccess(String success) {
      this.success = success;
      return this;
    }

    public void unsetSuccess() {
      this.success = null;
    }

    /** Returns true if field success is set (has been assigned a value) and false otherwise */
    public boolean isSetSuccess() {
      return this.success != null;
    }

    public void setSuccessIsSet(boolean value) {
      if (!value) {
        this.success = null;
      }
    }

    public void setFieldValue(_Fields field, Object value) {
      switch (field) {
        case SUCCESS:
          if (value == null) {
            unsetSuccess();
          } else {
            setSuccess((String) value);
          }
          break;
      }
    }

    public Object getFieldValue(_Fields field) {
      switch (field) {
        case SUCCESS:
          return getSuccess();
      }
      throw new IllegalStateException();
    }

    /**
     * Returns true if field corresponding to fieldID is set (has been assigned a value) and false
     * otherwise
     */
    public boolean isSet(_Fields field) {
      if (field == null) {
        throw new IllegalArgumentException();
      }

      switch (field) {
        case SUCCESS:
          return isSetSuccess();
      }
      throw new IllegalStateException();
    }

    @Override
    public boolean equals(Object that) {
      if (that == null) return false;
      if (that instanceof call_result) return this.equals((call_result) that);
      return false;
    }

    public boolean equals(call_result that) {
      if (that == null) return false;
      if (this == that) return true;

      boolean this_present_success = true && this.isSetSuccess();
      boolean that_present_success = true && that.isSetSuccess();
      if (this_present_success || that_present_success) {
        if (!(this_present_success && that_present_success)) return false;
        if (!this.success.equals(that.success)) return false;
      }

      return true;
    }

    @Override
    public int hashCode() {
      int hashCode = 1;

      hashCode = hashCode * 8191 + ((isSetSuccess()) ? 131071 : 524287);
      if (isSetSuccess()) hashCode = hashCode * 8191 + success.hashCode();

      return hashCode;
    }

    @Override
    public int compareTo(call_result other) {
      if (!getClass().equals(other.getClass())) {
        return getClass().getName().compareTo(other.getClass().getName());
      }

      int lastComparison = 0;

      lastComparison = Boolean.valueOf(isSetSuccess()).compareTo(other.isSetSuccess());
      if (lastComparison != 0) {
        return lastComparison;
      }
      if (isSetSuccess()) {
        lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.success, other.success);
        if (lastComparison != 0) {
          return lastComparison;
        }
      }
      return 0;
    }

    public _Fields fieldForId(int fieldId) {
      return _Fields.findByThriftId(fieldId);
    }

    public void read(org.apache.thrift.protocol.TProtocol iprot)
        throws org.apache.thrift.TException {
      scheme(iprot).read(iprot, this);
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot)
        throws org.apache.thrift.TException {
      scheme(oprot).write(oprot, this);
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder("call_result(");
      boolean first = true;

      sb.append("success:");
      if (this.success == null) {
        sb.append("null");
      } else {
        sb.append(this.success);
      }
      first = false;
      sb.append(")");
      return sb.toString();
    }

    public void validate() throws org.apache.thrift.TException {
      // check for required fields
      // check for sub-struct validity
    }

    private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
      try {
        write(
            new org.apache.thrift.protocol.TCompactProtocol(
                new org.apache.thrift.transport.TIOStreamTransport(out)));
      } catch (org.apache.thrift.TException te) {
        throw new java.io.IOException(te);
      }
    }

    private void readObject(java.io.ObjectInputStream in)
        throws java.io.IOException, ClassNotFoundException {
      try {
        read(
            new org.apache.thrift.protocol.TCompactProtocol(
                new org.apache.thrift.transport.TIOStreamTransport(in)));
      } catch (org.apache.thrift.TException te) {
        throw new java.io.IOException(te);
      }
    }

    private static class call_resultStandardSchemeFactory
        implements org.apache.thrift.scheme.SchemeFactory {
      public call_resultStandardScheme getScheme() {
        return new call_resultStandardScheme();
      }
    }

    private static class call_resultStandardScheme
        extends org.apache.thrift.scheme.StandardScheme<call_result> {

      public void read(org.apache.thrift.protocol.TProtocol iprot, call_result struct)
          throws org.apache.thrift.TException {
        org.apache.thrift.protocol.TField schemeField;
        iprot.readStructBegin();
        while (true) {
          schemeField = iprot.readFieldBegin();
          if (schemeField.type == org.apache.thrift.protocol.TType.STOP) {
            break;
          }
          switch (schemeField.id) {
            case 0: // SUCCESS
              if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
                struct.success = iprot.readString();
                struct.setSuccessIsSet(true);
              } else {
                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
              }
              break;
            default:
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
          }
          iprot.readFieldEnd();
        }
        iprot.readStructEnd();

        // check for required fields of primitive type, which can't be checked in the
        // validate method
        struct.validate();
      }

      public void write(org.apache.thrift.protocol.TProtocol oprot, call_result struct)
          throws org.apache.thrift.TException {
        struct.validate();

        oprot.writeStructBegin(STRUCT_DESC);
        if (struct.success != null) {
          oprot.writeFieldBegin(SUCCESS_FIELD_DESC);
          oprot.writeString(struct.success);
          oprot.writeFieldEnd();
        }
        oprot.writeFieldStop();
        oprot.writeStructEnd();
      }
    }

    private static class call_resultTupleSchemeFactory
        implements org.apache.thrift.scheme.SchemeFactory {
      public call_resultTupleScheme getScheme() {
        return new call_resultTupleScheme();
      }
    }

    private static class call_resultTupleScheme
        extends org.apache.thrift.scheme.TupleScheme<call_result> {

      @Override
      public void write(org.apache.thrift.protocol.TProtocol prot, call_result struct)
          throws org.apache.thrift.TException {
        org.apache.thrift.protocol.TTupleProtocol oprot =
            (org.apache.thrift.protocol.TTupleProtocol) prot;
        java.util.BitSet optionals = new java.util.BitSet();
        if (struct.isSetSuccess()) {
          optionals.set(0);
        }
        oprot.writeBitSet(optionals, 1);
        if (struct.isSetSuccess()) {
          oprot.writeString(struct.success);
        }
      }

      @Override
      public void read(org.apache.thrift.protocol.TProtocol prot, call_result struct)
          throws org.apache.thrift.TException {
        org.apache.thrift.protocol.TTupleProtocol iprot =
            (org.apache.thrift.protocol.TTupleProtocol) prot;
        java.util.BitSet incoming = iprot.readBitSet(1);
        if (incoming.get(0)) {
          struct.success = iprot.readString();
          struct.setSuccessIsSet(true);
        }
      }
    }

    private static <S extends org.apache.thrift.scheme.IScheme> S scheme(
        org.apache.thrift.protocol.TProtocol proto) {
      return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme())
              ? STANDARD_SCHEME_FACTORY
              : TUPLE_SCHEME_FACTORY)
          .getScheme();
    }
  }
}

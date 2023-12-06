
package group14final.theavengers_stg_0_1;

import routines.Numeric;
import routines.DataOperation;
import routines.TalendDataGenerator;
import routines.TalendStringUtil;
import routines.TalendString;
import routines.StringHandling;
import routines.Relational;
import routines.TalendDate;
import routines.Mathematical;
import routines.SQLike;
import routines.system.*;
import routines.system.api.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.math.BigDecimal;
import java.io.ByteArrayOutputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.util.Comparator;

@SuppressWarnings("unused")

/**
 * Job: TheAvengers_stg Purpose: <br>
 * Description: <br>
 * 
 * @author jain.harshj@northeastern.edu
 * @version 8.0.1.20231116_0906-patch
 * @status
 */
public class TheAvengers_stg implements TalendJob {
	static {
		System.setProperty("TalendJob.log", "TheAvengers_stg.log");
	}

	private static org.apache.logging.log4j.Logger log = org.apache.logging.log4j.LogManager
			.getLogger(TheAvengers_stg.class);

	protected static void logIgnoredError(String message, Throwable cause) {
		log.error(message, cause);

	}

	public final Object obj = new Object();

	// for transmiting parameters purpose
	private Object valueObject = null;

	public Object getValueObject() {
		return this.valueObject;
	}

	public void setValueObject(Object valueObject) {
		this.valueObject = valueObject;
	}

	private final static String defaultCharset = java.nio.charset.Charset.defaultCharset().name();

	private final static String utf8Charset = "UTF-8";

	// contains type for every context property
	public class PropertiesWithType extends java.util.Properties {
		private static final long serialVersionUID = 1L;
		private java.util.Map<String, String> propertyTypes = new java.util.HashMap<>();

		public PropertiesWithType(java.util.Properties properties) {
			super(properties);
		}

		public PropertiesWithType() {
			super();
		}

		public void setContextType(String key, String type) {
			propertyTypes.put(key, type);
		}

		public String getContextType(String key) {
			return propertyTypes.get(key);
		}
	}

	// create and load default properties
	private java.util.Properties defaultProps = new java.util.Properties();

	// create application properties with default
	public class ContextProperties extends PropertiesWithType {

		private static final long serialVersionUID = 1L;

		public ContextProperties(java.util.Properties properties) {
			super(properties);
		}

		public ContextProperties() {
			super();
		}

		public void synchronizeContext() {

			if (TheAvengers_File != null) {

				this.setProperty("TheAvengers_File", TheAvengers_File.toString());

			}

			if (TheAvengers_Encoding != null) {

				this.setProperty("TheAvengers_Encoding", TheAvengers_Encoding.toString());

			}

			if (TheAvengers_RowSeparator != null) {

				this.setProperty("TheAvengers_RowSeparator", TheAvengers_RowSeparator.toString());

			}

			if (TheAvengers_FieldSeparator != null) {

				this.setProperty("TheAvengers_FieldSeparator", TheAvengers_FieldSeparator.toString());

			}

			if (TheAvengers_Header != null) {

				this.setProperty("TheAvengers_Header", TheAvengers_Header.toString());

			}

			if (imdb_Port != null) {

				this.setProperty("imdb_Port", imdb_Port.toString());

			}

			if (imdb_Database != null) {

				this.setProperty("imdb_Database", imdb_Database.toString());

			}

			if (imdb_Password != null) {

				this.setProperty("imdb_Password", imdb_Password.toString());

			}

			if (imdb_Login != null) {

				this.setProperty("imdb_Login", imdb_Login.toString());

			}

			if (imdb_Server != null) {

				this.setProperty("imdb_Server", imdb_Server.toString());

			}

			if (imdb_AdditionalParams != null) {

				this.setProperty("imdb_AdditionalParams", imdb_AdditionalParams.toString());

			}

		}

		// if the stored or passed value is "<TALEND_NULL>" string, it mean null
		public String getStringValue(String key) {
			String origin_value = this.getProperty(key);
			if (NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY.equals(origin_value)) {
				return null;
			}
			return origin_value;
		}

		public String TheAvengers_File;

		public String getTheAvengers_File() {
			return this.TheAvengers_File;
		}

		public String TheAvengers_Encoding;

		public String getTheAvengers_Encoding() {
			return this.TheAvengers_Encoding;
		}

		public String TheAvengers_RowSeparator;

		public String getTheAvengers_RowSeparator() {
			return this.TheAvengers_RowSeparator;
		}

		public String TheAvengers_FieldSeparator;

		public String getTheAvengers_FieldSeparator() {
			return this.TheAvengers_FieldSeparator;
		}

		public Integer TheAvengers_Header;

		public Integer getTheAvengers_Header() {
			return this.TheAvengers_Header;
		}

		public String imdb_Port;

		public String getImdb_Port() {
			return this.imdb_Port;
		}

		public String imdb_Database;

		public String getImdb_Database() {
			return this.imdb_Database;
		}

		public java.lang.String imdb_Password;

		public java.lang.String getImdb_Password() {
			return this.imdb_Password;
		}

		public String imdb_Login;

		public String getImdb_Login() {
			return this.imdb_Login;
		}

		public String imdb_Server;

		public String getImdb_Server() {
			return this.imdb_Server;
		}

		public String imdb_AdditionalParams;

		public String getImdb_AdditionalParams() {
			return this.imdb_AdditionalParams;
		}
	}

	protected ContextProperties context = new ContextProperties(); // will be instanciated by MS.

	public ContextProperties getContext() {
		return this.context;
	}

	private final String jobVersion = "0.1";
	private final String jobName = "TheAvengers_stg";
	private final String projectName = "GROUP14FINAL";
	public Integer errorCode = null;
	private String currentComponent = "";

	private String cLabel = null;

	private final java.util.Map<String, Object> globalMap = new java.util.HashMap<String, Object>();
	private final static java.util.Map<String, Object> junitGlobalMap = new java.util.HashMap<String, Object>();

	private final java.util.Map<String, Long> start_Hash = new java.util.HashMap<String, Long>();
	private final java.util.Map<String, Long> end_Hash = new java.util.HashMap<String, Long>();
	private final java.util.Map<String, Boolean> ok_Hash = new java.util.HashMap<String, Boolean>();
	public final java.util.List<String[]> globalBuffer = new java.util.ArrayList<String[]>();

	private final JobStructureCatcherUtils talendJobLog = new JobStructureCatcherUtils(jobName,
			"_dH6sEJAMEe6a__awYeGrfA", "0.1");
	private org.talend.job.audit.JobAuditLogger auditLogger_talendJobLog = null;

	private RunStat runStat = new RunStat(talendJobLog, System.getProperty("audit.interval"));

	// OSGi DataSource
	private final static String KEY_DB_DATASOURCES = "KEY_DB_DATASOURCES";

	private final static String KEY_DB_DATASOURCES_RAW = "KEY_DB_DATASOURCES_RAW";

	public void setDataSources(java.util.Map<String, javax.sql.DataSource> dataSources) {
		java.util.Map<String, routines.system.TalendDataSource> talendDataSources = new java.util.HashMap<String, routines.system.TalendDataSource>();
		for (java.util.Map.Entry<String, javax.sql.DataSource> dataSourceEntry : dataSources.entrySet()) {
			talendDataSources.put(dataSourceEntry.getKey(),
					new routines.system.TalendDataSource(dataSourceEntry.getValue()));
		}
		globalMap.put(KEY_DB_DATASOURCES, talendDataSources);
		globalMap.put(KEY_DB_DATASOURCES_RAW, new java.util.HashMap<String, javax.sql.DataSource>(dataSources));
	}

	public void setDataSourceReferences(List serviceReferences) throws Exception {

		java.util.Map<String, routines.system.TalendDataSource> talendDataSources = new java.util.HashMap<String, routines.system.TalendDataSource>();
		java.util.Map<String, javax.sql.DataSource> dataSources = new java.util.HashMap<String, javax.sql.DataSource>();

		for (java.util.Map.Entry<String, javax.sql.DataSource> entry : BundleUtils
				.getServices(serviceReferences, javax.sql.DataSource.class).entrySet()) {
			dataSources.put(entry.getKey(), entry.getValue());
			talendDataSources.put(entry.getKey(), new routines.system.TalendDataSource(entry.getValue()));
		}

		globalMap.put(KEY_DB_DATASOURCES, talendDataSources);
		globalMap.put(KEY_DB_DATASOURCES_RAW, new java.util.HashMap<String, javax.sql.DataSource>(dataSources));
	}

	private final java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
	private final java.io.PrintStream errorMessagePS = new java.io.PrintStream(new java.io.BufferedOutputStream(baos));

	public String getExceptionStackTrace() {
		if ("failure".equals(this.getStatus())) {
			errorMessagePS.flush();
			return baos.toString();
		}
		return null;
	}

	private Exception exception;

	public Exception getException() {
		if ("failure".equals(this.getStatus())) {
			return this.exception;
		}
		return null;
	}

	private class TalendException extends Exception {

		private static final long serialVersionUID = 1L;

		private java.util.Map<String, Object> globalMap = null;
		private Exception e = null;

		private String currentComponent = null;
		private String cLabel = null;

		private String virtualComponentName = null;

		public void setVirtualComponentName(String virtualComponentName) {
			this.virtualComponentName = virtualComponentName;
		}

		private TalendException(Exception e, String errorComponent, final java.util.Map<String, Object> globalMap) {
			this.currentComponent = errorComponent;
			this.globalMap = globalMap;
			this.e = e;
		}

		private TalendException(Exception e, String errorComponent, String errorComponentLabel,
				final java.util.Map<String, Object> globalMap) {
			this(e, errorComponent, globalMap);
			this.cLabel = errorComponentLabel;
		}

		public Exception getException() {
			return this.e;
		}

		public String getCurrentComponent() {
			return this.currentComponent;
		}

		public String getExceptionCauseMessage(Exception e) {
			Throwable cause = e;
			String message = null;
			int i = 10;
			while (null != cause && 0 < i--) {
				message = cause.getMessage();
				if (null == message) {
					cause = cause.getCause();
				} else {
					break;
				}
			}
			if (null == message) {
				message = e.getClass().getName();
			}
			return message;
		}

		@Override
		public void printStackTrace() {
			if (!(e instanceof TalendException || e instanceof TDieException)) {
				if (virtualComponentName != null && currentComponent.indexOf(virtualComponentName + "_") == 0) {
					globalMap.put(virtualComponentName + "_ERROR_MESSAGE", getExceptionCauseMessage(e));
				}
				globalMap.put(currentComponent + "_ERROR_MESSAGE", getExceptionCauseMessage(e));
				System.err.println("Exception in component " + currentComponent + " (" + jobName + ")");
			}
			if (!(e instanceof TDieException)) {
				if (e instanceof TalendException) {
					e.printStackTrace();
				} else {
					e.printStackTrace();
					e.printStackTrace(errorMessagePS);
					TheAvengers_stg.this.exception = e;
				}
			}
			if (!(e instanceof TalendException)) {
				try {
					for (java.lang.reflect.Method m : this.getClass().getEnclosingClass().getMethods()) {
						if (m.getName().compareTo(currentComponent + "_error") == 0) {
							m.invoke(TheAvengers_stg.this, new Object[] { e, currentComponent, globalMap });
							break;
						}
					}

					if (!(e instanceof TDieException)) {
						if (enableLogStash) {
							talendJobLog.addJobExceptionMessage(currentComponent, cLabel, null, e);
							talendJobLogProcess(globalMap);
						}
					}
				} catch (Exception e) {
					this.e.printStackTrace();
				}
			}
		}
	}

	public void tFileInputDelimited_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFileInputDelimited_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tMap_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFileInputDelimited_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDBOutput_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFileInputDelimited_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void talendJobLog_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		talendJobLog_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tFileInputDelimited_1_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public void talendJobLog_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public static class mysqlStruct implements routines.system.IPersistableRow<mysqlStruct> {
		final static byte[] commonByteArrayLock_GROUP14FINAL_TheAvengers_stg = new byte[0];
		static byte[] commonByteArray_GROUP14FINAL_TheAvengers_stg = new byte[0];

		public String tconst;

		public String getTconst() {
			return this.tconst;
		}

		public Boolean tconstIsNullable() {
			return true;
		}

		public Boolean tconstIsKey() {
			return false;
		}

		public Integer tconstLength() {
			return 9;
		}

		public Integer tconstPrecision() {
			return 0;
		}

		public String tconstDefault() {

			return null;

		}

		public String tconstComment() {

			return "";

		}

		public String tconstPattern() {

			return "";

		}

		public String tconstOriginalDbColumnName() {

			return "tconst";

		}

		public String title;

		public String getTitle() {
			return this.title;
		}

		public Boolean titleIsNullable() {
			return true;
		}

		public Boolean titleIsKey() {
			return false;
		}

		public Integer titleLength() {
			return 50;
		}

		public Integer titlePrecision() {
			return 0;
		}

		public String titleDefault() {

			return null;

		}

		public String titleComment() {

			return "";

		}

		public String titlePattern() {

			return "";

		}

		public String titleOriginalDbColumnName() {

			return "title";

		}

		public String Date;

		public String getDate() {
			return this.Date;
		}

		public Boolean DateIsNullable() {
			return true;
		}

		public Boolean DateIsKey() {
			return false;
		}

		public Integer DateLength() {
			return 12;
		}

		public Integer DatePrecision() {
			return 0;
		}

		public String DateDefault() {

			return null;

		}

		public String DateComment() {

			return "";

		}

		public String DatePattern() {

			return "";

		}

		public String DateOriginalDbColumnName() {

			return "Date";

		}

		public String Rank;

		public String getRank() {
			return this.Rank;
		}

		public Boolean RankIsNullable() {
			return true;
		}

		public Boolean RankIsKey() {
			return false;
		}

		public Integer RankLength() {
			return 2;
		}

		public Integer RankPrecision() {
			return 0;
		}

		public String RankDefault() {

			return null;

		}

		public String RankComment() {

			return "";

		}

		public String RankPattern() {

			return "";

		}

		public String RankOriginalDbColumnName() {

			return "Rank";

		}

		public String Gross;

		public String getGross() {
			return this.Gross;
		}

		public Boolean GrossIsNullable() {
			return true;
		}

		public Boolean GrossIsKey() {
			return false;
		}

		public Integer GrossLength() {
			return 11;
		}

		public Integer GrossPrecision() {
			return 0;
		}

		public String GrossDefault() {

			return null;

		}

		public String GrossComment() {

			return "";

		}

		public String GrossPattern() {

			return "";

		}

		public String GrossOriginalDbColumnName() {

			return "Gross";

		}

		public String _YD;

		public String get_YD() {
			return this._YD;
		}

		public Boolean _YDIsNullable() {
			return true;
		}

		public Boolean _YDIsKey() {
			return false;
		}

		public Integer _YDLength() {
			return 4;
		}

		public Integer _YDPrecision() {
			return 0;
		}

		public String _YDDefault() {

			return null;

		}

		public String _YDComment() {

			return "";

		}

		public String _YDPattern() {

			return "";

		}

		public String _YDOriginalDbColumnName() {

			return "_YD";

		}

		public String _LW;

		public String get_LW() {
			return this._LW;
		}

		public Boolean _LWIsNullable() {
			return true;
		}

		public Boolean _LWIsKey() {
			return false;
		}

		public Integer _LWLength() {
			return 4;
		}

		public Integer _LWPrecision() {
			return 0;
		}

		public String _LWDefault() {

			return null;

		}

		public String _LWComment() {

			return "";

		}

		public String _LWPattern() {

			return "";

		}

		public String _LWOriginalDbColumnName() {

			return "_LW";

		}

		public String Theaters;

		public String getTheaters() {
			return this.Theaters;
		}

		public Boolean TheatersIsNullable() {
			return true;
		}

		public Boolean TheatersIsKey() {
			return false;
		}

		public Integer TheatersLength() {
			return 5;
		}

		public Integer TheatersPrecision() {
			return 0;
		}

		public String TheatersDefault() {

			return null;

		}

		public String TheatersComment() {

			return "";

		}

		public String TheatersPattern() {

			return "";

		}

		public String TheatersOriginalDbColumnName() {

			return "Theaters";

		}

		public String Per_Theater;

		public String getPer_Theater() {
			return this.Per_Theater;
		}

		public Boolean Per_TheaterIsNullable() {
			return true;
		}

		public Boolean Per_TheaterIsKey() {
			return false;
		}

		public Integer Per_TheaterLength() {
			return 10;
		}

		public Integer Per_TheaterPrecision() {
			return 0;
		}

		public String Per_TheaterDefault() {

			return null;

		}

		public String Per_TheaterComment() {

			return "";

		}

		public String Per_TheaterPattern() {

			return "";

		}

		public String Per_TheaterOriginalDbColumnName() {

			return "Per_Theater";

		}

		public String Total_Gross;

		public String getTotal_Gross() {
			return this.Total_Gross;
		}

		public Boolean Total_GrossIsNullable() {
			return true;
		}

		public Boolean Total_GrossIsKey() {
			return false;
		}

		public Integer Total_GrossLength() {
			return 12;
		}

		public Integer Total_GrossPrecision() {
			return 0;
		}

		public String Total_GrossDefault() {

			return null;

		}

		public String Total_GrossComment() {

			return "";

		}

		public String Total_GrossPattern() {

			return "";

		}

		public String Total_GrossOriginalDbColumnName() {

			return "Total_Gross";

		}

		public Integer Days;

		public Integer getDays() {
			return this.Days;
		}

		public Boolean DaysIsNullable() {
			return true;
		}

		public Boolean DaysIsKey() {
			return false;
		}

		public Integer DaysLength() {
			return 10;
		}

		public Integer DaysPrecision() {
			return 0;
		}

		public String DaysDefault() {

			return null;

		}

		public String DaysComment() {

			return "";

		}

		public String DaysPattern() {

			return "";

		}

		public String DaysOriginalDbColumnName() {

			return "Days";

		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_GROUP14FINAL_TheAvengers_stg.length) {
					if (length < 1024 && commonByteArray_GROUP14FINAL_TheAvengers_stg.length == 0) {
						commonByteArray_GROUP14FINAL_TheAvengers_stg = new byte[1024];
					} else {
						commonByteArray_GROUP14FINAL_TheAvengers_stg = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_GROUP14FINAL_TheAvengers_stg, 0, length);
				strReturn = new String(commonByteArray_GROUP14FINAL_TheAvengers_stg, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_GROUP14FINAL_TheAvengers_stg.length) {
					if (length < 1024 && commonByteArray_GROUP14FINAL_TheAvengers_stg.length == 0) {
						commonByteArray_GROUP14FINAL_TheAvengers_stg = new byte[1024];
					} else {
						commonByteArray_GROUP14FINAL_TheAvengers_stg = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_GROUP14FINAL_TheAvengers_stg, 0, length);
				strReturn = new String(commonByteArray_GROUP14FINAL_TheAvengers_stg, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		private Integer readInteger(ObjectInputStream dis) throws IOException {
			Integer intReturn;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				intReturn = null;
			} else {
				intReturn = dis.readInt();
			}
			return intReturn;
		}

		private Integer readInteger(org.jboss.marshalling.Unmarshaller dis) throws IOException {
			Integer intReturn;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				intReturn = null;
			} else {
				intReturn = dis.readInt();
			}
			return intReturn;
		}

		private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException {
			if (intNum == null) {
				dos.writeByte(-1);
			} else {
				dos.writeByte(0);
				dos.writeInt(intNum);
			}
		}

		private void writeInteger(Integer intNum, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (intNum == null) {
				marshaller.writeByte(-1);
			} else {
				marshaller.writeByte(0);
				marshaller.writeInt(intNum);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_GROUP14FINAL_TheAvengers_stg) {

				try {

					int length = 0;

					this.tconst = readString(dis);

					this.title = readString(dis);

					this.Date = readString(dis);

					this.Rank = readString(dis);

					this.Gross = readString(dis);

					this._YD = readString(dis);

					this._LW = readString(dis);

					this.Theaters = readString(dis);

					this.Per_Theater = readString(dis);

					this.Total_Gross = readString(dis);

					this.Days = readInteger(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_GROUP14FINAL_TheAvengers_stg) {

				try {

					int length = 0;

					this.tconst = readString(dis);

					this.title = readString(dis);

					this.Date = readString(dis);

					this.Rank = readString(dis);

					this.Gross = readString(dis);

					this._YD = readString(dis);

					this._LW = readString(dis);

					this.Theaters = readString(dis);

					this.Per_Theater = readString(dis);

					this.Total_Gross = readString(dis);

					this.Days = readInteger(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.tconst, dos);

				// String

				writeString(this.title, dos);

				// String

				writeString(this.Date, dos);

				// String

				writeString(this.Rank, dos);

				// String

				writeString(this.Gross, dos);

				// String

				writeString(this._YD, dos);

				// String

				writeString(this._LW, dos);

				// String

				writeString(this.Theaters, dos);

				// String

				writeString(this.Per_Theater, dos);

				// String

				writeString(this.Total_Gross, dos);

				// Integer

				writeInteger(this.Days, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.tconst, dos);

				// String

				writeString(this.title, dos);

				// String

				writeString(this.Date, dos);

				// String

				writeString(this.Rank, dos);

				// String

				writeString(this.Gross, dos);

				// String

				writeString(this._YD, dos);

				// String

				writeString(this._LW, dos);

				// String

				writeString(this.Theaters, dos);

				// String

				writeString(this.Per_Theater, dos);

				// String

				writeString(this.Total_Gross, dos);

				// Integer

				writeInteger(this.Days, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("tconst=" + tconst);
			sb.append(",title=" + title);
			sb.append(",Date=" + Date);
			sb.append(",Rank=" + Rank);
			sb.append(",Gross=" + Gross);
			sb.append(",_YD=" + _YD);
			sb.append(",_LW=" + _LW);
			sb.append(",Theaters=" + Theaters);
			sb.append(",Per_Theater=" + Per_Theater);
			sb.append(",Total_Gross=" + Total_Gross);
			sb.append(",Days=" + String.valueOf(Days));
			sb.append("]");

			return sb.toString();
		}

		public String toLogString() {
			StringBuilder sb = new StringBuilder();

			if (tconst == null) {
				sb.append("<null>");
			} else {
				sb.append(tconst);
			}

			sb.append("|");

			if (title == null) {
				sb.append("<null>");
			} else {
				sb.append(title);
			}

			sb.append("|");

			if (Date == null) {
				sb.append("<null>");
			} else {
				sb.append(Date);
			}

			sb.append("|");

			if (Rank == null) {
				sb.append("<null>");
			} else {
				sb.append(Rank);
			}

			sb.append("|");

			if (Gross == null) {
				sb.append("<null>");
			} else {
				sb.append(Gross);
			}

			sb.append("|");

			if (_YD == null) {
				sb.append("<null>");
			} else {
				sb.append(_YD);
			}

			sb.append("|");

			if (_LW == null) {
				sb.append("<null>");
			} else {
				sb.append(_LW);
			}

			sb.append("|");

			if (Theaters == null) {
				sb.append("<null>");
			} else {
				sb.append(Theaters);
			}

			sb.append("|");

			if (Per_Theater == null) {
				sb.append("<null>");
			} else {
				sb.append(Per_Theater);
			}

			sb.append("|");

			if (Total_Gross == null) {
				sb.append("<null>");
			} else {
				sb.append(Total_Gross);
			}

			sb.append("|");

			if (Days == null) {
				sb.append("<null>");
			} else {
				sb.append(Days);
			}

			sb.append("|");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(mysqlStruct other) {

			int returnValue = -1;

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(), object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public static class row1Struct implements routines.system.IPersistableRow<row1Struct> {
		final static byte[] commonByteArrayLock_GROUP14FINAL_TheAvengers_stg = new byte[0];
		static byte[] commonByteArray_GROUP14FINAL_TheAvengers_stg = new byte[0];

		public String tconst;

		public String getTconst() {
			return this.tconst;
		}

		public Boolean tconstIsNullable() {
			return true;
		}

		public Boolean tconstIsKey() {
			return false;
		}

		public Integer tconstLength() {
			return 9;
		}

		public Integer tconstPrecision() {
			return 0;
		}

		public String tconstDefault() {

			return null;

		}

		public String tconstComment() {

			return "";

		}

		public String tconstPattern() {

			return "dd-MM-yyyy";

		}

		public String tconstOriginalDbColumnName() {

			return "tconst";

		}

		public String title;

		public String getTitle() {
			return this.title;
		}

		public Boolean titleIsNullable() {
			return true;
		}

		public Boolean titleIsKey() {
			return false;
		}

		public Integer titleLength() {
			return 12;
		}

		public Integer titlePrecision() {
			return 0;
		}

		public String titleDefault() {

			return null;

		}

		public String titleComment() {

			return "";

		}

		public String titlePattern() {

			return "dd-MM-yyyy";

		}

		public String titleOriginalDbColumnName() {

			return "title";

		}

		public String Date;

		public String getDate() {
			return this.Date;
		}

		public Boolean DateIsNullable() {
			return true;
		}

		public Boolean DateIsKey() {
			return false;
		}

		public Integer DateLength() {
			return 12;
		}

		public Integer DatePrecision() {
			return 0;
		}

		public String DateDefault() {

			return null;

		}

		public String DateComment() {

			return "";

		}

		public String DatePattern() {

			return "dd-MM-yyyy";

		}

		public String DateOriginalDbColumnName() {

			return "Date";

		}

		public String Rank;

		public String getRank() {
			return this.Rank;
		}

		public Boolean RankIsNullable() {
			return true;
		}

		public Boolean RankIsKey() {
			return false;
		}

		public Integer RankLength() {
			return 2;
		}

		public Integer RankPrecision() {
			return 0;
		}

		public String RankDefault() {

			return null;

		}

		public String RankComment() {

			return "";

		}

		public String RankPattern() {

			return "dd-MM-yyyy";

		}

		public String RankOriginalDbColumnName() {

			return "Rank";

		}

		public String Gross;

		public String getGross() {
			return this.Gross;
		}

		public Boolean GrossIsNullable() {
			return true;
		}

		public Boolean GrossIsKey() {
			return false;
		}

		public Integer GrossLength() {
			return 11;
		}

		public Integer GrossPrecision() {
			return 0;
		}

		public String GrossDefault() {

			return null;

		}

		public String GrossComment() {

			return "";

		}

		public String GrossPattern() {

			return "dd-MM-yyyy";

		}

		public String GrossOriginalDbColumnName() {

			return "Gross";

		}

		public String _YD;

		public String get_YD() {
			return this._YD;
		}

		public Boolean _YDIsNullable() {
			return true;
		}

		public Boolean _YDIsKey() {
			return false;
		}

		public Integer _YDLength() {
			return 4;
		}

		public Integer _YDPrecision() {
			return 0;
		}

		public String _YDDefault() {

			return null;

		}

		public String _YDComment() {

			return "";

		}

		public String _YDPattern() {

			return "dd-MM-yyyy";

		}

		public String _YDOriginalDbColumnName() {

			return "_YD";

		}

		public String _LW;

		public String get_LW() {
			return this._LW;
		}

		public Boolean _LWIsNullable() {
			return true;
		}

		public Boolean _LWIsKey() {
			return false;
		}

		public Integer _LWLength() {
			return 4;
		}

		public Integer _LWPrecision() {
			return 0;
		}

		public String _LWDefault() {

			return null;

		}

		public String _LWComment() {

			return "";

		}

		public String _LWPattern() {

			return "dd-MM-yyyy";

		}

		public String _LWOriginalDbColumnName() {

			return "_LW";

		}

		public String Theaters;

		public String getTheaters() {
			return this.Theaters;
		}

		public Boolean TheatersIsNullable() {
			return true;
		}

		public Boolean TheatersIsKey() {
			return false;
		}

		public Integer TheatersLength() {
			return 5;
		}

		public Integer TheatersPrecision() {
			return 0;
		}

		public String TheatersDefault() {

			return null;

		}

		public String TheatersComment() {

			return "";

		}

		public String TheatersPattern() {

			return "dd-MM-yyyy";

		}

		public String TheatersOriginalDbColumnName() {

			return "Theaters";

		}

		public String Per_Theater;

		public String getPer_Theater() {
			return this.Per_Theater;
		}

		public Boolean Per_TheaterIsNullable() {
			return true;
		}

		public Boolean Per_TheaterIsKey() {
			return false;
		}

		public Integer Per_TheaterLength() {
			return 7;
		}

		public Integer Per_TheaterPrecision() {
			return 0;
		}

		public String Per_TheaterDefault() {

			return null;

		}

		public String Per_TheaterComment() {

			return "";

		}

		public String Per_TheaterPattern() {

			return "dd-MM-yyyy";

		}

		public String Per_TheaterOriginalDbColumnName() {

			return "Per_Theater";

		}

		public String Total_Gross;

		public String getTotal_Gross() {
			return this.Total_Gross;
		}

		public Boolean Total_GrossIsNullable() {
			return true;
		}

		public Boolean Total_GrossIsKey() {
			return false;
		}

		public Integer Total_GrossLength() {
			return 12;
		}

		public Integer Total_GrossPrecision() {
			return 0;
		}

		public String Total_GrossDefault() {

			return null;

		}

		public String Total_GrossComment() {

			return "";

		}

		public String Total_GrossPattern() {

			return "dd-MM-yyyy";

		}

		public String Total_GrossOriginalDbColumnName() {

			return "Total_Gross";

		}

		public Integer Days;

		public Integer getDays() {
			return this.Days;
		}

		public Boolean DaysIsNullable() {
			return true;
		}

		public Boolean DaysIsKey() {
			return false;
		}

		public Integer DaysLength() {
			return 3;
		}

		public Integer DaysPrecision() {
			return 0;
		}

		public String DaysDefault() {

			return null;

		}

		public String DaysComment() {

			return "";

		}

		public String DaysPattern() {

			return "dd-MM-yyyy";

		}

		public String DaysOriginalDbColumnName() {

			return "Days";

		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_GROUP14FINAL_TheAvengers_stg.length) {
					if (length < 1024 && commonByteArray_GROUP14FINAL_TheAvengers_stg.length == 0) {
						commonByteArray_GROUP14FINAL_TheAvengers_stg = new byte[1024];
					} else {
						commonByteArray_GROUP14FINAL_TheAvengers_stg = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_GROUP14FINAL_TheAvengers_stg, 0, length);
				strReturn = new String(commonByteArray_GROUP14FINAL_TheAvengers_stg, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_GROUP14FINAL_TheAvengers_stg.length) {
					if (length < 1024 && commonByteArray_GROUP14FINAL_TheAvengers_stg.length == 0) {
						commonByteArray_GROUP14FINAL_TheAvengers_stg = new byte[1024];
					} else {
						commonByteArray_GROUP14FINAL_TheAvengers_stg = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_GROUP14FINAL_TheAvengers_stg, 0, length);
				strReturn = new String(commonByteArray_GROUP14FINAL_TheAvengers_stg, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		private Integer readInteger(ObjectInputStream dis) throws IOException {
			Integer intReturn;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				intReturn = null;
			} else {
				intReturn = dis.readInt();
			}
			return intReturn;
		}

		private Integer readInteger(org.jboss.marshalling.Unmarshaller dis) throws IOException {
			Integer intReturn;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				intReturn = null;
			} else {
				intReturn = dis.readInt();
			}
			return intReturn;
		}

		private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException {
			if (intNum == null) {
				dos.writeByte(-1);
			} else {
				dos.writeByte(0);
				dos.writeInt(intNum);
			}
		}

		private void writeInteger(Integer intNum, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (intNum == null) {
				marshaller.writeByte(-1);
			} else {
				marshaller.writeByte(0);
				marshaller.writeInt(intNum);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_GROUP14FINAL_TheAvengers_stg) {

				try {

					int length = 0;

					this.tconst = readString(dis);

					this.title = readString(dis);

					this.Date = readString(dis);

					this.Rank = readString(dis);

					this.Gross = readString(dis);

					this._YD = readString(dis);

					this._LW = readString(dis);

					this.Theaters = readString(dis);

					this.Per_Theater = readString(dis);

					this.Total_Gross = readString(dis);

					this.Days = readInteger(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_GROUP14FINAL_TheAvengers_stg) {

				try {

					int length = 0;

					this.tconst = readString(dis);

					this.title = readString(dis);

					this.Date = readString(dis);

					this.Rank = readString(dis);

					this.Gross = readString(dis);

					this._YD = readString(dis);

					this._LW = readString(dis);

					this.Theaters = readString(dis);

					this.Per_Theater = readString(dis);

					this.Total_Gross = readString(dis);

					this.Days = readInteger(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.tconst, dos);

				// String

				writeString(this.title, dos);

				// String

				writeString(this.Date, dos);

				// String

				writeString(this.Rank, dos);

				// String

				writeString(this.Gross, dos);

				// String

				writeString(this._YD, dos);

				// String

				writeString(this._LW, dos);

				// String

				writeString(this.Theaters, dos);

				// String

				writeString(this.Per_Theater, dos);

				// String

				writeString(this.Total_Gross, dos);

				// Integer

				writeInteger(this.Days, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.tconst, dos);

				// String

				writeString(this.title, dos);

				// String

				writeString(this.Date, dos);

				// String

				writeString(this.Rank, dos);

				// String

				writeString(this.Gross, dos);

				// String

				writeString(this._YD, dos);

				// String

				writeString(this._LW, dos);

				// String

				writeString(this.Theaters, dos);

				// String

				writeString(this.Per_Theater, dos);

				// String

				writeString(this.Total_Gross, dos);

				// Integer

				writeInteger(this.Days, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("tconst=" + tconst);
			sb.append(",title=" + title);
			sb.append(",Date=" + Date);
			sb.append(",Rank=" + Rank);
			sb.append(",Gross=" + Gross);
			sb.append(",_YD=" + _YD);
			sb.append(",_LW=" + _LW);
			sb.append(",Theaters=" + Theaters);
			sb.append(",Per_Theater=" + Per_Theater);
			sb.append(",Total_Gross=" + Total_Gross);
			sb.append(",Days=" + String.valueOf(Days));
			sb.append("]");

			return sb.toString();
		}

		public String toLogString() {
			StringBuilder sb = new StringBuilder();

			if (tconst == null) {
				sb.append("<null>");
			} else {
				sb.append(tconst);
			}

			sb.append("|");

			if (title == null) {
				sb.append("<null>");
			} else {
				sb.append(title);
			}

			sb.append("|");

			if (Date == null) {
				sb.append("<null>");
			} else {
				sb.append(Date);
			}

			sb.append("|");

			if (Rank == null) {
				sb.append("<null>");
			} else {
				sb.append(Rank);
			}

			sb.append("|");

			if (Gross == null) {
				sb.append("<null>");
			} else {
				sb.append(Gross);
			}

			sb.append("|");

			if (_YD == null) {
				sb.append("<null>");
			} else {
				sb.append(_YD);
			}

			sb.append("|");

			if (_LW == null) {
				sb.append("<null>");
			} else {
				sb.append(_LW);
			}

			sb.append("|");

			if (Theaters == null) {
				sb.append("<null>");
			} else {
				sb.append(Theaters);
			}

			sb.append("|");

			if (Per_Theater == null) {
				sb.append("<null>");
			} else {
				sb.append(Per_Theater);
			}

			sb.append("|");

			if (Total_Gross == null) {
				sb.append("<null>");
			} else {
				sb.append(Total_Gross);
			}

			sb.append("|");

			if (Days == null) {
				sb.append("<null>");
			} else {
				sb.append(Days);
			}

			sb.append("|");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(row1Struct other) {

			int returnValue = -1;

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(), object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public void tFileInputDelimited_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tFileInputDelimited_1_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		mdcInfo.forEach(org.slf4j.MDC::put);
		org.slf4j.MDC.put("_subJobName", "tFileInputDelimited_1");
		org.slf4j.MDC.put("_subJobPid", "vJackc_" + subJobPidCounter.getAndIncrement());

		String iterateId = "";

		String currentComponent = "";
		String cLabel = null;
		java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

		try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { // start the resume
				globalResumeTicket = true;

				row1Struct row1 = new row1Struct();
				mysqlStruct mysql = new mysqlStruct();

				/**
				 * [tDBOutput_1 begin ] start
				 */

				ok_Hash.put("tDBOutput_1", false);
				start_Hash.put("tDBOutput_1", System.currentTimeMillis());

				currentComponent = "tDBOutput_1";

				cLabel = "\"movie_numbers_stg\"";

				runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, 0, 0, "mysql");

				int tos_count_tDBOutput_1 = 0;

				if (log.isDebugEnabled())
					log.debug("tDBOutput_1 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tDBOutput_1 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tDBOutput_1 = new StringBuilder();
							log4jParamters_tDBOutput_1.append("Parameters:");
							log4jParamters_tDBOutput_1.append("DB_VERSION" + " = " + "MYSQL_8");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1.append("USE_EXISTING_CONNECTION" + " = " + "false");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1.append("HOST" + " = " + "context.imdb_Server");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1.append("PORT" + " = " + "context.imdb_Port");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1.append("DBNAME" + " = " + "context.imdb_Database");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1.append("USER" + " = " + "context.imdb_Login");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1.append("PASS" + " = "
									+ String.valueOf(
											routines.system.PasswordEncryptUtil.encryptPassword(context.imdb_Password))
											.substring(0, 4)
									+ "...");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1.append("TABLE" + " = " + "\"movie_numbers_stg\"");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1.append("TABLE_ACTION" + " = " + "NONE");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1.append("DATA_ACTION" + " = " + "INSERT");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1.append("SPECIFY_DATASOURCE_ALIAS" + " = " + "false");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1.append("DIE_ON_ERROR" + " = " + "false");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1.append("PROPERTIES" + " = " + "context.imdb_AdditionalParams");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1.append("EXTENDINSERT" + " = " + "true");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1.append("NB_ROWS_PER_INSERT" + " = " + "100");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1.append("COMMIT_EVERY" + " = " + "10000");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1.append("ADD_COLS" + " = " + "[]");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1.append("USE_FIELD_OPTIONS" + " = " + "false");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1.append("USE_HINT_OPTIONS" + " = " + "false");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1.append("ENABLE_DEBUG_MODE" + " = " + "false");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1.append("ON_DUPLICATE_KEY_UPDATE" + " = " + "false");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1.append("UNIFIED_COMPONENTS" + " = " + "tMysqlOutput");
							log4jParamters_tDBOutput_1.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tDBOutput_1 - " + (log4jParamters_tDBOutput_1));
						}
					}
					new BytesLimit65535_tDBOutput_1().limitLog4jByte();
				}
				if (enableLogStash) {
					talendJobLog.addCM("tDBOutput_1", "\"movie_numbers_stg\"", "tMysqlOutput");
					talendJobLogProcess(globalMap);
				}

				int nb_line_tDBOutput_1 = 0;
				int nb_line_update_tDBOutput_1 = 0;
				int nb_line_inserted_tDBOutput_1 = 0;
				int nb_line_deleted_tDBOutput_1 = 0;
				int nb_line_rejected_tDBOutput_1 = 0;

				int deletedCount_tDBOutput_1 = 0;
				int updatedCount_tDBOutput_1 = 0;
				int insertedCount_tDBOutput_1 = 0;
				int rowsToCommitCount_tDBOutput_1 = 0;
				int rejectedCount_tDBOutput_1 = 0;

				String tableName_tDBOutput_1 = "movie_numbers_stg";
				boolean whetherReject_tDBOutput_1 = false;

				java.util.Calendar calendar_tDBOutput_1 = java.util.Calendar.getInstance();
				calendar_tDBOutput_1.set(1, 0, 1, 0, 0, 0);
				long year1_tDBOutput_1 = calendar_tDBOutput_1.getTime().getTime();
				calendar_tDBOutput_1.set(10000, 0, 1, 0, 0, 0);
				long year10000_tDBOutput_1 = calendar_tDBOutput_1.getTime().getTime();
				long date_tDBOutput_1;

				java.sql.Connection conn_tDBOutput_1 = null;

				String properties_tDBOutput_1 = context.imdb_AdditionalParams;
				if (properties_tDBOutput_1 == null || properties_tDBOutput_1.trim().length() == 0) {
					properties_tDBOutput_1 = "rewriteBatchedStatements=true&allowLoadLocalInfile=true";
				} else {
					if (!properties_tDBOutput_1.contains("rewriteBatchedStatements=")) {
						properties_tDBOutput_1 += "&rewriteBatchedStatements=true";
					}

					if (!properties_tDBOutput_1.contains("allowLoadLocalInfile=")) {
						properties_tDBOutput_1 += "&allowLoadLocalInfile=true";
					}
				}

				String url_tDBOutput_1 = "jdbc:mysql://" + context.imdb_Server + ":" + context.imdb_Port + "/"
						+ context.imdb_Database + "?" + properties_tDBOutput_1;

				String driverClass_tDBOutput_1 = "com.mysql.cj.jdbc.Driver";

				if (log.isDebugEnabled())
					log.debug("tDBOutput_1 - " + ("Driver ClassName: ") + (driverClass_tDBOutput_1) + ("."));
				String dbUser_tDBOutput_1 = context.imdb_Login;

				final String decryptedPassword_tDBOutput_1 = context.imdb_Password;

				String dbPwd_tDBOutput_1 = decryptedPassword_tDBOutput_1;
				java.lang.Class.forName(driverClass_tDBOutput_1);

				if (log.isDebugEnabled())
					log.debug("tDBOutput_1 - " + ("Connection attempts to '") + (url_tDBOutput_1)
							+ ("' with the username '") + (dbUser_tDBOutput_1) + ("'."));
				conn_tDBOutput_1 = java.sql.DriverManager.getConnection(url_tDBOutput_1, dbUser_tDBOutput_1,
						dbPwd_tDBOutput_1);

				if (log.isDebugEnabled())
					log.debug("tDBOutput_1 - " + ("Connection to '") + (url_tDBOutput_1) + ("' has succeeded."));

				resourceMap.put("conn_tDBOutput_1", conn_tDBOutput_1);

				conn_tDBOutput_1.setAutoCommit(false);
				int commitEvery_tDBOutput_1 = 10000;
				int commitCounter_tDBOutput_1 = 0;

				if (log.isDebugEnabled())
					log.debug("tDBOutput_1 - " + ("Connection is set auto commit to '")
							+ (conn_tDBOutput_1.getAutoCommit()) + ("'."));

				int count_tDBOutput_1 = 0;

				String insert_tDBOutput_1 = "INSERT INTO `" + "movie_numbers_stg"
						+ "` (`tconst`,`title`,`Date`,`Rank`,`Gross`,`_YD`,`_LW`,`Theaters`,`Per_Theater`,`Total_Gross`,`Days`) VALUES (?,?,?,?,?,?,?,?,?,?,?)";

				int batchSize_tDBOutput_1 = 100;
				int batchSizeCounter_tDBOutput_1 = 0;

				java.sql.PreparedStatement pstmt_tDBOutput_1 = conn_tDBOutput_1.prepareStatement(insert_tDBOutput_1);
				resourceMap.put("pstmt_tDBOutput_1", pstmt_tDBOutput_1);

				/**
				 * [tDBOutput_1 begin ] stop
				 */

				/**
				 * [tMap_1 begin ] start
				 */

				ok_Hash.put("tMap_1", false);
				start_Hash.put("tMap_1", System.currentTimeMillis());

				currentComponent = "tMap_1";

				runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, 0, 0, "row1");

				int tos_count_tMap_1 = 0;

				if (log.isDebugEnabled())
					log.debug("tMap_1 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tMap_1 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tMap_1 = new StringBuilder();
							log4jParamters_tMap_1.append("Parameters:");
							log4jParamters_tMap_1.append("LINK_STYLE" + " = " + "AUTO");
							log4jParamters_tMap_1.append(" | ");
							log4jParamters_tMap_1.append("TEMPORARY_DATA_DIRECTORY" + " = " + "");
							log4jParamters_tMap_1.append(" | ");
							log4jParamters_tMap_1.append("ROWS_BUFFER_SIZE" + " = " + "2000000");
							log4jParamters_tMap_1.append(" | ");
							log4jParamters_tMap_1.append("CHANGE_HASH_AND_EQUALS_FOR_BIGDECIMAL" + " = " + "true");
							log4jParamters_tMap_1.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tMap_1 - " + (log4jParamters_tMap_1));
						}
					}
					new BytesLimit65535_tMap_1().limitLog4jByte();
				}
				if (enableLogStash) {
					talendJobLog.addCM("tMap_1", "tMap_1", "tMap");
					talendJobLogProcess(globalMap);
				}

// ###############################
// # Lookup's keys initialization
				int count_row1_tMap_1 = 0;

// ###############################        

// ###############################
// # Vars initialization
				class Var__tMap_1__Struct {
				}
				Var__tMap_1__Struct Var__tMap_1 = new Var__tMap_1__Struct();
// ###############################

// ###############################
// # Outputs initialization
				int count_mysql_tMap_1 = 0;

				mysqlStruct mysql_tmp = new mysqlStruct();
// ###############################

				/**
				 * [tMap_1 begin ] stop
				 */

				/**
				 * [tFileInputDelimited_1 begin ] start
				 */

				ok_Hash.put("tFileInputDelimited_1", false);
				start_Hash.put("tFileInputDelimited_1", System.currentTimeMillis());

				currentComponent = "tFileInputDelimited_1";

				cLabel = "TheAvengers";

				int tos_count_tFileInputDelimited_1 = 0;

				if (log.isDebugEnabled())
					log.debug("tFileInputDelimited_1 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tFileInputDelimited_1 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tFileInputDelimited_1 = new StringBuilder();
							log4jParamters_tFileInputDelimited_1.append("Parameters:");
							log4jParamters_tFileInputDelimited_1.append("USE_EXISTING_DYNAMIC" + " = " + "false");
							log4jParamters_tFileInputDelimited_1.append(" | ");
							log4jParamters_tFileInputDelimited_1
									.append("FILENAME" + " = " + "context.TheAvengers_File");
							log4jParamters_tFileInputDelimited_1.append(" | ");
							log4jParamters_tFileInputDelimited_1.append("CSV_OPTION" + " = " + "false");
							log4jParamters_tFileInputDelimited_1.append(" | ");
							log4jParamters_tFileInputDelimited_1
									.append("ROWSEPARATOR" + " = " + "context.TheAvengers_RowSeparator");
							log4jParamters_tFileInputDelimited_1.append(" | ");
							log4jParamters_tFileInputDelimited_1
									.append("FIELDSEPARATOR" + " = " + "context.TheAvengers_FieldSeparator");
							log4jParamters_tFileInputDelimited_1.append(" | ");
							log4jParamters_tFileInputDelimited_1
									.append("HEADER" + " = " + "context.TheAvengers_Header");
							log4jParamters_tFileInputDelimited_1.append(" | ");
							log4jParamters_tFileInputDelimited_1.append("FOOTER" + " = " + "0");
							log4jParamters_tFileInputDelimited_1.append(" | ");
							log4jParamters_tFileInputDelimited_1.append("LIMIT" + " = " + "");
							log4jParamters_tFileInputDelimited_1.append(" | ");
							log4jParamters_tFileInputDelimited_1.append("REMOVE_EMPTY_ROW" + " = " + "false");
							log4jParamters_tFileInputDelimited_1.append(" | ");
							log4jParamters_tFileInputDelimited_1.append("UNCOMPRESS" + " = " + "false");
							log4jParamters_tFileInputDelimited_1.append(" | ");
							log4jParamters_tFileInputDelimited_1.append("DIE_ON_ERROR" + " = " + "false");
							log4jParamters_tFileInputDelimited_1.append(" | ");
							log4jParamters_tFileInputDelimited_1.append("ADVANCED_SEPARATOR" + " = " + "false");
							log4jParamters_tFileInputDelimited_1.append(" | ");
							log4jParamters_tFileInputDelimited_1.append("RANDOM" + " = " + "false");
							log4jParamters_tFileInputDelimited_1.append(" | ");
							log4jParamters_tFileInputDelimited_1.append("TRIMALL" + " = " + "false");
							log4jParamters_tFileInputDelimited_1.append(" | ");
							log4jParamters_tFileInputDelimited_1.append("TRIMSELECT" + " = " + "[{TRIM=" + ("false")
									+ ", SCHEMA_COLUMN=" + ("tconst") + "}, {TRIM=" + ("false") + ", SCHEMA_COLUMN="
									+ ("title") + "}, {TRIM=" + ("false") + ", SCHEMA_COLUMN=" + ("Date") + "}, {TRIM="
									+ ("false") + ", SCHEMA_COLUMN=" + ("Rank") + "}, {TRIM=" + ("false")
									+ ", SCHEMA_COLUMN=" + ("Gross") + "}, {TRIM=" + ("false") + ", SCHEMA_COLUMN="
									+ ("_YD") + "}, {TRIM=" + ("false") + ", SCHEMA_COLUMN=" + ("_LW") + "}, {TRIM="
									+ ("false") + ", SCHEMA_COLUMN=" + ("Theaters") + "}, {TRIM=" + ("false")
									+ ", SCHEMA_COLUMN=" + ("Per_Theater") + "}, {TRIM=" + ("false")
									+ ", SCHEMA_COLUMN=" + ("Total_Gross") + "}, {TRIM=" + ("false")
									+ ", SCHEMA_COLUMN=" + ("Days") + "}]");
							log4jParamters_tFileInputDelimited_1.append(" | ");
							log4jParamters_tFileInputDelimited_1.append("CHECK_FIELDS_NUM" + " = " + "false");
							log4jParamters_tFileInputDelimited_1.append(" | ");
							log4jParamters_tFileInputDelimited_1.append("CHECK_DATE" + " = " + "false");
							log4jParamters_tFileInputDelimited_1.append(" | ");
							log4jParamters_tFileInputDelimited_1
									.append("ENCODING" + " = " + "context.TheAvengers_Encoding");
							log4jParamters_tFileInputDelimited_1.append(" | ");
							log4jParamters_tFileInputDelimited_1.append("SPLITRECORD" + " = " + "false");
							log4jParamters_tFileInputDelimited_1.append(" | ");
							log4jParamters_tFileInputDelimited_1.append("ENABLE_DECODE" + " = " + "false");
							log4jParamters_tFileInputDelimited_1.append(" | ");
							log4jParamters_tFileInputDelimited_1.append("USE_HEADER_AS_IS" + " = " + "false");
							log4jParamters_tFileInputDelimited_1.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tFileInputDelimited_1 - " + (log4jParamters_tFileInputDelimited_1));
						}
					}
					new BytesLimit65535_tFileInputDelimited_1().limitLog4jByte();
				}
				if (enableLogStash) {
					talendJobLog.addCM("tFileInputDelimited_1", "TheAvengers", "tFileInputDelimited");
					talendJobLogProcess(globalMap);
				}

				final routines.system.RowState rowstate_tFileInputDelimited_1 = new routines.system.RowState();

				int nb_line_tFileInputDelimited_1 = 0;
				org.talend.fileprocess.FileInputDelimited fid_tFileInputDelimited_1 = null;
				int limit_tFileInputDelimited_1 = -1;
				try {

					Object filename_tFileInputDelimited_1 = context.TheAvengers_File;
					if (filename_tFileInputDelimited_1 instanceof java.io.InputStream) {

						int footer_value_tFileInputDelimited_1 = 0, random_value_tFileInputDelimited_1 = -1;
						if (footer_value_tFileInputDelimited_1 > 0 || random_value_tFileInputDelimited_1 > 0) {
							throw new java.lang.Exception(
									"When the input source is a stream,footer and random shouldn't be bigger than 0.");
						}

					}
					try {
						fid_tFileInputDelimited_1 = new org.talend.fileprocess.FileInputDelimited(
								context.TheAvengers_File, context.TheAvengers_Encoding,
								context.TheAvengers_FieldSeparator, context.TheAvengers_RowSeparator, false,
								context.TheAvengers_Header, 0, limit_tFileInputDelimited_1, -1, false);
					} catch (java.lang.Exception e) {
						globalMap.put("tFileInputDelimited_1_ERROR_MESSAGE", e.getMessage());

						log.error("tFileInputDelimited_1 - " + e.getMessage());

						System.err.println(e.getMessage());

					}

					log.info("tFileInputDelimited_1 - Retrieving records from the datasource.");

					while (fid_tFileInputDelimited_1 != null && fid_tFileInputDelimited_1.nextRecord()) {
						rowstate_tFileInputDelimited_1.reset();

						row1 = null;

						boolean whetherReject_tFileInputDelimited_1 = false;
						row1 = new row1Struct();
						try {

							int columnIndexWithD_tFileInputDelimited_1 = 0;

							String temp = "";

							columnIndexWithD_tFileInputDelimited_1 = 0;

							row1.tconst = fid_tFileInputDelimited_1.get(columnIndexWithD_tFileInputDelimited_1);

							columnIndexWithD_tFileInputDelimited_1 = 1;

							row1.title = fid_tFileInputDelimited_1.get(columnIndexWithD_tFileInputDelimited_1);

							columnIndexWithD_tFileInputDelimited_1 = 2;

							row1.Date = fid_tFileInputDelimited_1.get(columnIndexWithD_tFileInputDelimited_1);

							columnIndexWithD_tFileInputDelimited_1 = 3;

							row1.Rank = fid_tFileInputDelimited_1.get(columnIndexWithD_tFileInputDelimited_1);

							columnIndexWithD_tFileInputDelimited_1 = 4;

							row1.Gross = fid_tFileInputDelimited_1.get(columnIndexWithD_tFileInputDelimited_1);

							columnIndexWithD_tFileInputDelimited_1 = 5;

							row1._YD = fid_tFileInputDelimited_1.get(columnIndexWithD_tFileInputDelimited_1);

							columnIndexWithD_tFileInputDelimited_1 = 6;

							row1._LW = fid_tFileInputDelimited_1.get(columnIndexWithD_tFileInputDelimited_1);

							columnIndexWithD_tFileInputDelimited_1 = 7;

							row1.Theaters = fid_tFileInputDelimited_1.get(columnIndexWithD_tFileInputDelimited_1);

							columnIndexWithD_tFileInputDelimited_1 = 8;

							row1.Per_Theater = fid_tFileInputDelimited_1.get(columnIndexWithD_tFileInputDelimited_1);

							columnIndexWithD_tFileInputDelimited_1 = 9;

							row1.Total_Gross = fid_tFileInputDelimited_1.get(columnIndexWithD_tFileInputDelimited_1);

							columnIndexWithD_tFileInputDelimited_1 = 10;

							temp = fid_tFileInputDelimited_1.get(columnIndexWithD_tFileInputDelimited_1);
							if (temp.length() > 0) {

								try {

									row1.Days = ParserUtils.parseTo_Integer(temp);

								} catch (java.lang.Exception ex_tFileInputDelimited_1) {
									globalMap.put("tFileInputDelimited_1_ERROR_MESSAGE",
											ex_tFileInputDelimited_1.getMessage());
									rowstate_tFileInputDelimited_1.setException(new RuntimeException(String.format(
											"Couldn't parse value for column '%s' in '%s', value is '%s'. Details: %s",
											"Days", "row1", temp, ex_tFileInputDelimited_1), ex_tFileInputDelimited_1));
								}

							} else {

								row1.Days = null;

							}

							if (rowstate_tFileInputDelimited_1.getException() != null) {
								throw rowstate_tFileInputDelimited_1.getException();
							}

						} catch (java.lang.Exception e) {
							globalMap.put("tFileInputDelimited_1_ERROR_MESSAGE", e.getMessage());
							whetherReject_tFileInputDelimited_1 = true;

							log.error("tFileInputDelimited_1 - " + e.getMessage());

							System.err.println(e.getMessage());
							row1 = null;

						}

						log.debug("tFileInputDelimited_1 - Retrieving the record "
								+ fid_tFileInputDelimited_1.getRowNumber() + ".");

						/**
						 * [tFileInputDelimited_1 begin ] stop
						 */

						/**
						 * [tFileInputDelimited_1 main ] start
						 */

						currentComponent = "tFileInputDelimited_1";

						cLabel = "TheAvengers";

						tos_count_tFileInputDelimited_1++;

						/**
						 * [tFileInputDelimited_1 main ] stop
						 */

						/**
						 * [tFileInputDelimited_1 process_data_begin ] start
						 */

						currentComponent = "tFileInputDelimited_1";

						cLabel = "TheAvengers";

						/**
						 * [tFileInputDelimited_1 process_data_begin ] stop
						 */
// Start of branch "row1"
						if (row1 != null) {

							/**
							 * [tMap_1 main ] start
							 */

							currentComponent = "tMap_1";

							if (runStat.update(execStat, enableLogStash, iterateId, 1, 1

									, "row1", "tFileInputDelimited_1", "TheAvengers", "tFileInputDelimited", "tMap_1",
									"tMap_1", "tMap"

							)) {
								talendJobLogProcess(globalMap);
							}

							if (log.isTraceEnabled()) {
								log.trace("row1 - " + (row1 == null ? "" : row1.toLogString()));
							}

							boolean hasCasePrimitiveKeyWithNull_tMap_1 = false;

							// ###############################
							// # Input tables (lookups)

							boolean rejectedInnerJoin_tMap_1 = false;
							boolean mainRowRejected_tMap_1 = false;
							// ###############################
							{ // start of Var scope

								// ###############################
								// # Vars tables

								Var__tMap_1__Struct Var = Var__tMap_1;// ###############################
								// ###############################
								// # Output tables

								mysql = null;

// # Output table : 'mysql'
								count_mysql_tMap_1++;

								mysql_tmp.tconst = row1.tconst;
								mysql_tmp.title = row1.title;
								mysql_tmp.Date = row1.Date;
								mysql_tmp.Rank = row1.Rank;
								mysql_tmp.Gross = row1.Gross;
								mysql_tmp._YD = row1._YD;
								mysql_tmp._LW = row1._LW;
								mysql_tmp.Theaters = row1.Theaters;
								mysql_tmp.Per_Theater = row1.Per_Theater;
								mysql_tmp.Total_Gross = row1.Total_Gross;
								mysql_tmp.Days = row1.Days;
								mysql = mysql_tmp;
								log.debug("tMap_1 - Outputting the record " + count_mysql_tMap_1
										+ " of the output table 'mysql'.");

// ###############################

							} // end of Var scope

							rejectedInnerJoin_tMap_1 = false;

							tos_count_tMap_1++;

							/**
							 * [tMap_1 main ] stop
							 */

							/**
							 * [tMap_1 process_data_begin ] start
							 */

							currentComponent = "tMap_1";

							/**
							 * [tMap_1 process_data_begin ] stop
							 */
// Start of branch "mysql"
							if (mysql != null) {

								/**
								 * [tDBOutput_1 main ] start
								 */

								currentComponent = "tDBOutput_1";

								cLabel = "\"movie_numbers_stg\"";

								if (runStat.update(execStat, enableLogStash, iterateId, 1, 1

										, "mysql", "tMap_1", "tMap_1", "tMap", "tDBOutput_1", "\"movie_numbers_stg\"",
										"tMysqlOutput"

								)) {
									talendJobLogProcess(globalMap);
								}

								if (log.isTraceEnabled()) {
									log.trace("mysql - " + (mysql == null ? "" : mysql.toLogString()));
								}

								whetherReject_tDBOutput_1 = false;
								if (mysql.tconst == null) {
									pstmt_tDBOutput_1.setNull(1, java.sql.Types.VARCHAR);
								} else {
									pstmt_tDBOutput_1.setString(1, mysql.tconst);
								}

								if (mysql.title == null) {
									pstmt_tDBOutput_1.setNull(2, java.sql.Types.VARCHAR);
								} else {
									pstmt_tDBOutput_1.setString(2, mysql.title);
								}

								if (mysql.Date == null) {
									pstmt_tDBOutput_1.setNull(3, java.sql.Types.VARCHAR);
								} else {
									pstmt_tDBOutput_1.setString(3, mysql.Date);
								}

								if (mysql.Rank == null) {
									pstmt_tDBOutput_1.setNull(4, java.sql.Types.VARCHAR);
								} else {
									pstmt_tDBOutput_1.setString(4, mysql.Rank);
								}

								if (mysql.Gross == null) {
									pstmt_tDBOutput_1.setNull(5, java.sql.Types.VARCHAR);
								} else {
									pstmt_tDBOutput_1.setString(5, mysql.Gross);
								}

								if (mysql._YD == null) {
									pstmt_tDBOutput_1.setNull(6, java.sql.Types.VARCHAR);
								} else {
									pstmt_tDBOutput_1.setString(6, mysql._YD);
								}

								if (mysql._LW == null) {
									pstmt_tDBOutput_1.setNull(7, java.sql.Types.VARCHAR);
								} else {
									pstmt_tDBOutput_1.setString(7, mysql._LW);
								}

								if (mysql.Theaters == null) {
									pstmt_tDBOutput_1.setNull(8, java.sql.Types.VARCHAR);
								} else {
									pstmt_tDBOutput_1.setString(8, mysql.Theaters);
								}

								if (mysql.Per_Theater == null) {
									pstmt_tDBOutput_1.setNull(9, java.sql.Types.VARCHAR);
								} else {
									pstmt_tDBOutput_1.setString(9, mysql.Per_Theater);
								}

								if (mysql.Total_Gross == null) {
									pstmt_tDBOutput_1.setNull(10, java.sql.Types.VARCHAR);
								} else {
									pstmt_tDBOutput_1.setString(10, mysql.Total_Gross);
								}

								if (mysql.Days == null) {
									pstmt_tDBOutput_1.setNull(11, java.sql.Types.INTEGER);
								} else {
									pstmt_tDBOutput_1.setInt(11, mysql.Days);
								}

								pstmt_tDBOutput_1.addBatch();
								nb_line_tDBOutput_1++;

								if (log.isDebugEnabled())
									log.debug("tDBOutput_1 - " + ("Adding the record ") + (nb_line_tDBOutput_1)
											+ (" to the ") + ("INSERT") + (" batch."));
								batchSizeCounter_tDBOutput_1++;
								if (batchSize_tDBOutput_1 <= batchSizeCounter_tDBOutput_1) {
									try {
										int countSum_tDBOutput_1 = 0;
										if (log.isDebugEnabled())
											log.debug("tDBOutput_1 - " + ("Executing the ") + ("INSERT") + (" batch."));
										for (int countEach_tDBOutput_1 : pstmt_tDBOutput_1.executeBatch()) {
											countSum_tDBOutput_1 += (countEach_tDBOutput_1 == java.sql.Statement.EXECUTE_FAILED
													? 0
													: 1);
										}
										rowsToCommitCount_tDBOutput_1 += countSum_tDBOutput_1;
										if (log.isDebugEnabled())
											log.debug("tDBOutput_1 - " + ("The ") + ("INSERT")
													+ (" batch execution has succeeded."));
										insertedCount_tDBOutput_1 += countSum_tDBOutput_1;
									} catch (java.sql.BatchUpdateException e) {
										globalMap.put("tDBOutput_1_ERROR_MESSAGE", e.getMessage());
										int countSum_tDBOutput_1 = 0;
										for (int countEach_tDBOutput_1 : e.getUpdateCounts()) {
											countSum_tDBOutput_1 += (countEach_tDBOutput_1 < 0 ? 0
													: countEach_tDBOutput_1);
										}
										rowsToCommitCount_tDBOutput_1 += countSum_tDBOutput_1;
										insertedCount_tDBOutput_1 += countSum_tDBOutput_1;
										System.err.println(e.getMessage());
										log.error("tDBOutput_1 - " + (e.getMessage()));
									}

									batchSizeCounter_tDBOutput_1 = 0;
								}
								commitCounter_tDBOutput_1++;

								if (commitEvery_tDBOutput_1 <= commitCounter_tDBOutput_1) {

									try {
										int countSum_tDBOutput_1 = 0;
										if (log.isDebugEnabled())
											log.debug("tDBOutput_1 - " + ("Executing the ") + ("INSERT") + (" batch."));
										for (int countEach_tDBOutput_1 : pstmt_tDBOutput_1.executeBatch()) {
											countSum_tDBOutput_1 += (countEach_tDBOutput_1 < 0 ? 0 : 1);
										}
										rowsToCommitCount_tDBOutput_1 += countSum_tDBOutput_1;
										if (log.isDebugEnabled())
											log.debug("tDBOutput_1 - " + ("The ") + ("INSERT")
													+ (" batch execution has succeeded."));
										insertedCount_tDBOutput_1 += countSum_tDBOutput_1;
									} catch (java.sql.BatchUpdateException e) {
										globalMap.put("tDBOutput_1_ERROR_MESSAGE", e.getMessage());
										int countSum_tDBOutput_1 = 0;
										for (int countEach_tDBOutput_1 : e.getUpdateCounts()) {
											countSum_tDBOutput_1 += (countEach_tDBOutput_1 < 0 ? 0
													: countEach_tDBOutput_1);
										}
										rowsToCommitCount_tDBOutput_1 += countSum_tDBOutput_1;
										insertedCount_tDBOutput_1 += countSum_tDBOutput_1;
										System.err.println(e.getMessage());
										log.error("tDBOutput_1 - " + (e.getMessage()));

									}
									if (rowsToCommitCount_tDBOutput_1 != 0) {
										if (log.isDebugEnabled())
											log.debug("tDBOutput_1 - " + ("Connection starting to commit ")
													+ (rowsToCommitCount_tDBOutput_1) + (" record(s)."));
									}
									conn_tDBOutput_1.commit();
									if (rowsToCommitCount_tDBOutput_1 != 0) {
										if (log.isDebugEnabled())
											log.debug("tDBOutput_1 - " + ("Connection commit has succeeded."));
										rowsToCommitCount_tDBOutput_1 = 0;
									}
									commitCounter_tDBOutput_1 = 0;
								}

								tos_count_tDBOutput_1++;

								/**
								 * [tDBOutput_1 main ] stop
								 */

								/**
								 * [tDBOutput_1 process_data_begin ] start
								 */

								currentComponent = "tDBOutput_1";

								cLabel = "\"movie_numbers_stg\"";

								/**
								 * [tDBOutput_1 process_data_begin ] stop
								 */

								/**
								 * [tDBOutput_1 process_data_end ] start
								 */

								currentComponent = "tDBOutput_1";

								cLabel = "\"movie_numbers_stg\"";

								/**
								 * [tDBOutput_1 process_data_end ] stop
								 */

							} // End of branch "mysql"

							/**
							 * [tMap_1 process_data_end ] start
							 */

							currentComponent = "tMap_1";

							/**
							 * [tMap_1 process_data_end ] stop
							 */

						} // End of branch "row1"

						/**
						 * [tFileInputDelimited_1 process_data_end ] start
						 */

						currentComponent = "tFileInputDelimited_1";

						cLabel = "TheAvengers";

						/**
						 * [tFileInputDelimited_1 process_data_end ] stop
						 */

						/**
						 * [tFileInputDelimited_1 end ] start
						 */

						currentComponent = "tFileInputDelimited_1";

						cLabel = "TheAvengers";

					}
				} finally {
					if (!((Object) (context.TheAvengers_File) instanceof java.io.InputStream)) {
						if (fid_tFileInputDelimited_1 != null) {
							fid_tFileInputDelimited_1.close();
						}
					}
					if (fid_tFileInputDelimited_1 != null) {
						globalMap.put("tFileInputDelimited_1_NB_LINE", fid_tFileInputDelimited_1.getRowNumber());

						log.info("tFileInputDelimited_1 - Retrieved records count: "
								+ fid_tFileInputDelimited_1.getRowNumber() + ".");

					}
				}

				if (log.isDebugEnabled())
					log.debug("tFileInputDelimited_1 - " + ("Done."));

				ok_Hash.put("tFileInputDelimited_1", true);
				end_Hash.put("tFileInputDelimited_1", System.currentTimeMillis());

				/**
				 * [tFileInputDelimited_1 end ] stop
				 */

				/**
				 * [tMap_1 end ] start
				 */

				currentComponent = "tMap_1";

// ###############################
// # Lookup hashes releasing
// ###############################      
				log.debug("tMap_1 - Written records count in the table 'mysql': " + count_mysql_tMap_1 + ".");

				if (runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, "row1", 2, 0,
						"tFileInputDelimited_1", "TheAvengers", "tFileInputDelimited", "tMap_1", "tMap_1", "tMap",
						"output")) {
					talendJobLogProcess(globalMap);
				}

				if (log.isDebugEnabled())
					log.debug("tMap_1 - " + ("Done."));

				ok_Hash.put("tMap_1", true);
				end_Hash.put("tMap_1", System.currentTimeMillis());

				/**
				 * [tMap_1 end ] stop
				 */

				/**
				 * [tDBOutput_1 end ] start
				 */

				currentComponent = "tDBOutput_1";

				cLabel = "\"movie_numbers_stg\"";

				try {
					if (batchSizeCounter_tDBOutput_1 != 0) {
						int countSum_tDBOutput_1 = 0;

						if (log.isDebugEnabled())
							log.debug("tDBOutput_1 - " + ("Executing the ") + ("INSERT") + (" batch."));
						for (int countEach_tDBOutput_1 : pstmt_tDBOutput_1.executeBatch()) {
							countSum_tDBOutput_1 += (countEach_tDBOutput_1 == java.sql.Statement.EXECUTE_FAILED ? 0
									: 1);
						}
						rowsToCommitCount_tDBOutput_1 += countSum_tDBOutput_1;

						if (log.isDebugEnabled())
							log.debug("tDBOutput_1 - " + ("The ") + ("INSERT") + (" batch execution has succeeded."));

						insertedCount_tDBOutput_1 += countSum_tDBOutput_1;

					}
				} catch (java.sql.BatchUpdateException e) {
					globalMap.put(currentComponent + "_ERROR_MESSAGE", e.getMessage());

					int countSum_tDBOutput_1 = 0;
					for (int countEach_tDBOutput_1 : e.getUpdateCounts()) {
						countSum_tDBOutput_1 += (countEach_tDBOutput_1 < 0 ? 0 : countEach_tDBOutput_1);
					}
					rowsToCommitCount_tDBOutput_1 += countSum_tDBOutput_1;

					insertedCount_tDBOutput_1 += countSum_tDBOutput_1;

					log.error("tDBOutput_1 - " + (e.getMessage()));
					System.err.println(e.getMessage());

				}
				batchSizeCounter_tDBOutput_1 = 0;

				if (pstmt_tDBOutput_1 != null) {

					pstmt_tDBOutput_1.close();
					resourceMap.remove("pstmt_tDBOutput_1");

				}

				resourceMap.put("statementClosed_tDBOutput_1", true);

				if (commitCounter_tDBOutput_1 > 0 && rowsToCommitCount_tDBOutput_1 != 0) {

					if (log.isDebugEnabled())
						log.debug("tDBOutput_1 - " + ("Connection starting to commit ")
								+ (rowsToCommitCount_tDBOutput_1) + (" record(s)."));
				}
				conn_tDBOutput_1.commit();
				if (commitCounter_tDBOutput_1 > 0 && rowsToCommitCount_tDBOutput_1 != 0) {

					if (log.isDebugEnabled())
						log.debug("tDBOutput_1 - " + ("Connection commit has succeeded."));
					rowsToCommitCount_tDBOutput_1 = 0;
				}
				commitCounter_tDBOutput_1 = 0;

				if (log.isDebugEnabled())
					log.debug("tDBOutput_1 - " + ("Closing the connection to the database."));
				conn_tDBOutput_1.close();

				if (log.isDebugEnabled())
					log.debug("tDBOutput_1 - " + ("Connection to the database has closed."));
				resourceMap.put("finish_tDBOutput_1", true);

				nb_line_deleted_tDBOutput_1 = nb_line_deleted_tDBOutput_1 + deletedCount_tDBOutput_1;
				nb_line_update_tDBOutput_1 = nb_line_update_tDBOutput_1 + updatedCount_tDBOutput_1;
				nb_line_inserted_tDBOutput_1 = nb_line_inserted_tDBOutput_1 + insertedCount_tDBOutput_1;
				nb_line_rejected_tDBOutput_1 = nb_line_rejected_tDBOutput_1 + rejectedCount_tDBOutput_1;

				globalMap.put("tDBOutput_1_NB_LINE", nb_line_tDBOutput_1);
				globalMap.put("tDBOutput_1_NB_LINE_UPDATED", nb_line_update_tDBOutput_1);
				globalMap.put("tDBOutput_1_NB_LINE_INSERTED", nb_line_inserted_tDBOutput_1);
				globalMap.put("tDBOutput_1_NB_LINE_DELETED", nb_line_deleted_tDBOutput_1);
				globalMap.put("tDBOutput_1_NB_LINE_REJECTED", nb_line_rejected_tDBOutput_1);

				if (log.isDebugEnabled())
					log.debug("tDBOutput_1 - " + ("Has ") + ("inserted") + (" ") + (nb_line_inserted_tDBOutput_1)
							+ (" record(s)."));

				if (runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, "mysql", 2, 0, "tMap_1",
						"tMap_1", "tMap", "tDBOutput_1", "\"movie_numbers_stg\"", "tMysqlOutput", "output")) {
					talendJobLogProcess(globalMap);
				}

				if (log.isDebugEnabled())
					log.debug("tDBOutput_1 - " + ("Done."));

				ok_Hash.put("tDBOutput_1", true);
				end_Hash.put("tDBOutput_1", System.currentTimeMillis());

				/**
				 * [tDBOutput_1 end ] stop
				 */

			} // end the resume

		} catch (java.lang.Exception e) {

			if (!(e instanceof TalendException)) {
				log.fatal(currentComponent + " " + e.getMessage(), e);
			}

			TalendException te = new TalendException(e, currentComponent, cLabel, globalMap);

			throw te;
		} catch (java.lang.Error error) {

			runStat.stopThreadStat();

			throw error;
		} finally {

			try {

				/**
				 * [tFileInputDelimited_1 finally ] start
				 */

				currentComponent = "tFileInputDelimited_1";

				cLabel = "TheAvengers";

				/**
				 * [tFileInputDelimited_1 finally ] stop
				 */

				/**
				 * [tMap_1 finally ] start
				 */

				currentComponent = "tMap_1";

				/**
				 * [tMap_1 finally ] stop
				 */

				/**
				 * [tDBOutput_1 finally ] start
				 */

				currentComponent = "tDBOutput_1";

				cLabel = "\"movie_numbers_stg\"";

				try {
					if (resourceMap.get("statementClosed_tDBOutput_1") == null) {
						java.sql.PreparedStatement pstmtToClose_tDBOutput_1 = null;
						if ((pstmtToClose_tDBOutput_1 = (java.sql.PreparedStatement) resourceMap
								.remove("pstmt_tDBOutput_1")) != null) {
							pstmtToClose_tDBOutput_1.close();
						}
					}
				} finally {
					if (resourceMap.get("finish_tDBOutput_1") == null) {
						java.sql.Connection ctn_tDBOutput_1 = null;
						if ((ctn_tDBOutput_1 = (java.sql.Connection) resourceMap.get("conn_tDBOutput_1")) != null) {
							try {
								if (log.isDebugEnabled())
									log.debug("tDBOutput_1 - " + ("Closing the connection to the database."));
								ctn_tDBOutput_1.close();
								if (log.isDebugEnabled())
									log.debug("tDBOutput_1 - " + ("Connection to the database has closed."));
							} catch (java.sql.SQLException sqlEx_tDBOutput_1) {
								String errorMessage_tDBOutput_1 = "failed to close the connection in tDBOutput_1 :"
										+ sqlEx_tDBOutput_1.getMessage();
								log.error("tDBOutput_1 - " + (errorMessage_tDBOutput_1));
								System.err.println(errorMessage_tDBOutput_1);
							}
						}
					}
				}

				/**
				 * [tDBOutput_1 finally ] stop
				 */

			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tFileInputDelimited_1_SUBPROCESS_STATE", 1);
	}

	public void talendJobLogProcess(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("talendJobLog_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		mdcInfo.forEach(org.slf4j.MDC::put);
		org.slf4j.MDC.put("_subJobName", "talendJobLog");
		org.slf4j.MDC.put("_subJobPid", "lk1cVO_" + subJobPidCounter.getAndIncrement());

		String iterateId = "";

		String currentComponent = "";
		String cLabel = null;
		java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

		try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { // start the resume
				globalResumeTicket = true;

				/**
				 * [talendJobLog begin ] start
				 */

				ok_Hash.put("talendJobLog", false);
				start_Hash.put("talendJobLog", System.currentTimeMillis());

				currentComponent = "talendJobLog";

				int tos_count_talendJobLog = 0;

				for (JobStructureCatcherUtils.JobStructureCatcherMessage jcm : talendJobLog.getMessages()) {
					org.talend.job.audit.JobContextBuilder builder_talendJobLog = org.talend.job.audit.JobContextBuilder
							.create().jobName(jcm.job_name).jobId(jcm.job_id).jobVersion(jcm.job_version)
							.custom("process_id", jcm.pid).custom("thread_id", jcm.tid).custom("pid", pid)
							.custom("father_pid", fatherPid).custom("root_pid", rootPid);
					org.talend.logging.audit.Context log_context_talendJobLog = null;

					if (jcm.log_type == JobStructureCatcherUtils.LogType.PERFORMANCE) {
						long timeMS = jcm.end_time - jcm.start_time;
						String duration = String.valueOf(timeMS);

						log_context_talendJobLog = builder_talendJobLog.sourceId(jcm.sourceId)
								.sourceLabel(jcm.sourceLabel).sourceConnectorType(jcm.sourceComponentName)
								.targetId(jcm.targetId).targetLabel(jcm.targetLabel)
								.targetConnectorType(jcm.targetComponentName).connectionName(jcm.current_connector)
								.rows(jcm.row_count).duration(duration).build();
						auditLogger_talendJobLog.flowExecution(log_context_talendJobLog);
					} else if (jcm.log_type == JobStructureCatcherUtils.LogType.JOBSTART) {
						log_context_talendJobLog = builder_talendJobLog.timestamp(jcm.moment).build();
						auditLogger_talendJobLog.jobstart(log_context_talendJobLog);
					} else if (jcm.log_type == JobStructureCatcherUtils.LogType.JOBEND) {
						long timeMS = jcm.end_time - jcm.start_time;
						String duration = String.valueOf(timeMS);

						log_context_talendJobLog = builder_talendJobLog.timestamp(jcm.moment).duration(duration)
								.status(jcm.status).build();
						auditLogger_talendJobLog.jobstop(log_context_talendJobLog);
					} else if (jcm.log_type == JobStructureCatcherUtils.LogType.RUNCOMPONENT) {
						log_context_talendJobLog = builder_talendJobLog.timestamp(jcm.moment)
								.connectorType(jcm.component_name).connectorId(jcm.component_id)
								.connectorLabel(jcm.component_label).build();
						auditLogger_talendJobLog.runcomponent(log_context_talendJobLog);
					} else if (jcm.log_type == JobStructureCatcherUtils.LogType.FLOWINPUT) {// log current component
																							// input line
						long timeMS = jcm.end_time - jcm.start_time;
						String duration = String.valueOf(timeMS);

						log_context_talendJobLog = builder_talendJobLog.connectorType(jcm.component_name)
								.connectorId(jcm.component_id).connectorLabel(jcm.component_label)
								.connectionName(jcm.current_connector).connectionType(jcm.current_connector_type)
								.rows(jcm.total_row_number).duration(duration).build();
						auditLogger_talendJobLog.flowInput(log_context_talendJobLog);
					} else if (jcm.log_type == JobStructureCatcherUtils.LogType.FLOWOUTPUT) {// log current component
																								// output/reject line
						long timeMS = jcm.end_time - jcm.start_time;
						String duration = String.valueOf(timeMS);

						log_context_talendJobLog = builder_talendJobLog.connectorType(jcm.component_name)
								.connectorId(jcm.component_id).connectorLabel(jcm.component_label)
								.connectionName(jcm.current_connector).connectionType(jcm.current_connector_type)
								.rows(jcm.total_row_number).duration(duration).build();
						auditLogger_talendJobLog.flowOutput(log_context_talendJobLog);
					} else if (jcm.log_type == JobStructureCatcherUtils.LogType.JOBERROR) {
						java.lang.Exception e_talendJobLog = jcm.exception;
						if (e_talendJobLog != null) {
							try (java.io.StringWriter sw_talendJobLog = new java.io.StringWriter();
									java.io.PrintWriter pw_talendJobLog = new java.io.PrintWriter(sw_talendJobLog)) {
								e_talendJobLog.printStackTrace(pw_talendJobLog);
								builder_talendJobLog.custom("stacktrace", sw_talendJobLog.getBuffer().substring(0,
										java.lang.Math.min(sw_talendJobLog.getBuffer().length(), 512)));
							}
						}

						if (jcm.extra_info != null) {
							builder_talendJobLog.connectorId(jcm.component_id).custom("extra_info", jcm.extra_info);
						}

						log_context_talendJobLog = builder_talendJobLog
								.connectorType(jcm.component_id.substring(0, jcm.component_id.lastIndexOf('_')))
								.connectorId(jcm.component_id)
								.connectorLabel(jcm.component_label == null ? jcm.component_id : jcm.component_label)
								.build();

						auditLogger_talendJobLog.exception(log_context_talendJobLog);
					}

				}

				/**
				 * [talendJobLog begin ] stop
				 */

				/**
				 * [talendJobLog main ] start
				 */

				currentComponent = "talendJobLog";

				tos_count_talendJobLog++;

				/**
				 * [talendJobLog main ] stop
				 */

				/**
				 * [talendJobLog process_data_begin ] start
				 */

				currentComponent = "talendJobLog";

				/**
				 * [talendJobLog process_data_begin ] stop
				 */

				/**
				 * [talendJobLog process_data_end ] start
				 */

				currentComponent = "talendJobLog";

				/**
				 * [talendJobLog process_data_end ] stop
				 */

				/**
				 * [talendJobLog end ] start
				 */

				currentComponent = "talendJobLog";

				ok_Hash.put("talendJobLog", true);
				end_Hash.put("talendJobLog", System.currentTimeMillis());

				/**
				 * [talendJobLog end ] stop
				 */
			} // end the resume

		} catch (java.lang.Exception e) {

			if (!(e instanceof TalendException)) {
				log.fatal(currentComponent + " " + e.getMessage(), e);
			}

			TalendException te = new TalendException(e, currentComponent, cLabel, globalMap);

			throw te;
		} catch (java.lang.Error error) {

			runStat.stopThreadStat();

			throw error;
		} finally {

			try {

				/**
				 * [talendJobLog finally ] start
				 */

				currentComponent = "talendJobLog";

				/**
				 * [talendJobLog finally ] stop
				 */
			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("talendJobLog_SUBPROCESS_STATE", 1);
	}

	public String resuming_logs_dir_path = null;
	public String resuming_checkpoint_path = null;
	public String parent_part_launcher = null;
	private String resumeEntryMethodName = null;
	private boolean globalResumeTicket = false;

	public boolean watch = false;
	// portStats is null, it means don't execute the statistics
	public Integer portStats = null;
	public int portTraces = 4334;
	public String clientHost;
	public String defaultClientHost = "localhost";
	public String contextStr = "Default";
	public boolean isDefaultContext = true;
	public String pid = "0";
	public String rootPid = null;
	public String fatherPid = null;
	public String fatherNode = null;
	public long startTime = 0;
	public boolean isChildJob = false;
	public String log4jLevel = "";

	private boolean enableLogStash;

	private boolean execStat = true;

	private ThreadLocal<java.util.Map<String, String>> threadLocal = new ThreadLocal<java.util.Map<String, String>>() {
		protected java.util.Map<String, String> initialValue() {
			java.util.Map<String, String> threadRunResultMap = new java.util.HashMap<String, String>();
			threadRunResultMap.put("errorCode", null);
			threadRunResultMap.put("status", "");
			return threadRunResultMap;
		};
	};

	protected PropertiesWithType context_param = new PropertiesWithType();
	public java.util.Map<String, Object> parentContextMap = new java.util.HashMap<String, Object>();

	public String status = "";

	private final static java.util.Properties jobInfo = new java.util.Properties();
	private final static java.util.Map<String, String> mdcInfo = new java.util.HashMap<>();
	private final static java.util.concurrent.atomic.AtomicLong subJobPidCounter = new java.util.concurrent.atomic.AtomicLong();

	public static void main(String[] args) {
		final TheAvengers_stg TheAvengers_stgClass = new TheAvengers_stg();

		int exitCode = TheAvengers_stgClass.runJobInTOS(args);
		if (exitCode == 0) {
			log.info("TalendJob: 'TheAvengers_stg' - Done.");
		}

		System.exit(exitCode);
	}

	private void getjobInfo() {
		final String TEMPLATE_PATH = "src/main/templates/jobInfo_template.properties";
		final String BUILD_PATH = "../jobInfo.properties";
		final String path = this.getClass().getResource("").getPath();
		if (path.lastIndexOf("target") > 0) {
			final java.io.File templateFile = new java.io.File(
					path.substring(0, path.lastIndexOf("target")).concat(TEMPLATE_PATH));
			if (templateFile.exists()) {
				readJobInfo(templateFile);
				return;
			}
		}
		readJobInfo(new java.io.File(BUILD_PATH));
	}

	private void readJobInfo(java.io.File jobInfoFile) {

		if (jobInfoFile.exists()) {
			try (java.io.InputStream is = new java.io.FileInputStream(jobInfoFile)) {
				jobInfo.load(is);
			} catch (IOException e) {

				log.debug("Read jobInfo.properties file fail: " + e.getMessage());

			}
		}
		log.info(String.format("Project name: %s\tJob name: %s\tGIT Commit ID: %s\tTalend Version: %s", projectName,
				jobName, jobInfo.getProperty("gitCommitId"), "8.0.1.20231116_0906-patch"));

	}

	public String[][] runJob(String[] args) {

		int exitCode = runJobInTOS(args);
		String[][] bufferValue = new String[][] { { Integer.toString(exitCode) } };

		return bufferValue;
	}

	public boolean hastBufferOutputComponent() {
		boolean hastBufferOutput = false;

		return hastBufferOutput;
	}

	public int runJobInTOS(String[] args) {
		// reset status
		status = "";

		String lastStr = "";
		for (String arg : args) {
			if (arg.equalsIgnoreCase("--context_param")) {
				lastStr = arg;
			} else if (lastStr.equals("")) {
				evalParam(arg);
			} else {
				evalParam(lastStr + " " + arg);
				lastStr = "";
			}
		}
		enableLogStash = "true".equalsIgnoreCase(System.getProperty("audit.enabled"));

		if (!"".equals(log4jLevel)) {

			if ("trace".equalsIgnoreCase(log4jLevel)) {
				org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(),
						org.apache.logging.log4j.Level.TRACE);
			} else if ("debug".equalsIgnoreCase(log4jLevel)) {
				org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(),
						org.apache.logging.log4j.Level.DEBUG);
			} else if ("info".equalsIgnoreCase(log4jLevel)) {
				org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(),
						org.apache.logging.log4j.Level.INFO);
			} else if ("warn".equalsIgnoreCase(log4jLevel)) {
				org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(),
						org.apache.logging.log4j.Level.WARN);
			} else if ("error".equalsIgnoreCase(log4jLevel)) {
				org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(),
						org.apache.logging.log4j.Level.ERROR);
			} else if ("fatal".equalsIgnoreCase(log4jLevel)) {
				org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(),
						org.apache.logging.log4j.Level.FATAL);
			} else if ("off".equalsIgnoreCase(log4jLevel)) {
				org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(),
						org.apache.logging.log4j.Level.OFF);
			}
			org.apache.logging.log4j.core.config.Configurator
					.setLevel(org.apache.logging.log4j.LogManager.getRootLogger().getName(), log.getLevel());

		}

		getjobInfo();
		log.info("TalendJob: 'TheAvengers_stg' - Start.");

		java.util.Set<Object> jobInfoKeys = jobInfo.keySet();
		for (Object jobInfoKey : jobInfoKeys) {
			org.slf4j.MDC.put("_" + jobInfoKey.toString(), jobInfo.get(jobInfoKey).toString());
		}
		org.slf4j.MDC.put("_pid", pid);
		org.slf4j.MDC.put("_rootPid", rootPid);
		org.slf4j.MDC.put("_fatherPid", fatherPid);
		org.slf4j.MDC.put("_projectName", projectName);
		org.slf4j.MDC.put("_startTimestamp", java.time.ZonedDateTime.now(java.time.ZoneOffset.UTC)
				.format(java.time.format.DateTimeFormatter.ISO_INSTANT));
		org.slf4j.MDC.put("_jobRepositoryId", "_dH6sEJAMEe6a__awYeGrfA");
		org.slf4j.MDC.put("_compiledAtTimestamp", "2023-12-03T02:12:51.401501100Z");

		java.lang.management.RuntimeMXBean mx = java.lang.management.ManagementFactory.getRuntimeMXBean();
		String[] mxNameTable = mx.getName().split("@"); //$NON-NLS-1$
		if (mxNameTable.length == 2) {
			org.slf4j.MDC.put("_systemPid", mxNameTable[0]);
		} else {
			org.slf4j.MDC.put("_systemPid", String.valueOf(java.lang.Thread.currentThread().getId()));
		}

		if (enableLogStash) {
			java.util.Properties properties_talendJobLog = new java.util.Properties();
			properties_talendJobLog.setProperty("root.logger", "audit");
			properties_talendJobLog.setProperty("encoding", "UTF-8");
			properties_talendJobLog.setProperty("application.name", "Talend Studio");
			properties_talendJobLog.setProperty("service.name", "Talend Studio Job");
			properties_talendJobLog.setProperty("instance.name", "Talend Studio Job Instance");
			properties_talendJobLog.setProperty("propagate.appender.exceptions", "none");
			properties_talendJobLog.setProperty("log.appender", "file");
			properties_talendJobLog.setProperty("appender.file.path", "audit.json");
			properties_talendJobLog.setProperty("appender.file.maxsize", "52428800");
			properties_talendJobLog.setProperty("appender.file.maxbackup", "20");
			properties_talendJobLog.setProperty("host", "false");

			System.getProperties().stringPropertyNames().stream().filter(it -> it.startsWith("audit.logger."))
					.forEach(key -> properties_talendJobLog.setProperty(key.substring("audit.logger.".length()),
							System.getProperty(key)));

			org.apache.logging.log4j.core.config.Configurator
					.setLevel(properties_talendJobLog.getProperty("root.logger"), org.apache.logging.log4j.Level.DEBUG);

			auditLogger_talendJobLog = org.talend.job.audit.JobEventAuditLoggerFactory
					.createJobAuditLogger(properties_talendJobLog);
		}

		if (clientHost == null) {
			clientHost = defaultClientHost;
		}

		if (pid == null || "0".equals(pid)) {
			pid = TalendString.getAsciiRandomString(6);
		}

		org.slf4j.MDC.put("_pid", pid);

		if (rootPid == null) {
			rootPid = pid;
		}

		org.slf4j.MDC.put("_rootPid", rootPid);

		if (fatherPid == null) {
			fatherPid = pid;
		} else {
			isChildJob = true;
		}
		org.slf4j.MDC.put("_fatherPid", fatherPid);

		if (portStats != null) {
			// portStats = -1; //for testing
			if (portStats < 0 || portStats > 65535) {
				// issue:10869, the portStats is invalid, so this client socket can't open
				System.err.println("The statistics socket port " + portStats + " is invalid.");
				execStat = false;
			}
		} else {
			execStat = false;
		}
		boolean inOSGi = routines.system.BundleUtils.inOSGi();

		try {
			java.util.Dictionary<String, Object> jobProperties = null;
			if (inOSGi) {
				jobProperties = routines.system.BundleUtils.getJobProperties(jobName);

				if (jobProperties != null && jobProperties.get("context") != null) {
					contextStr = (String) jobProperties.get("context");
				}
			}
			// call job/subjob with an existing context, like: --context=production. if
			// without this parameter, there will use the default context instead.
			java.io.InputStream inContext = TheAvengers_stg.class.getClassLoader()
					.getResourceAsStream("group14final/theavengers_stg_0_1/contexts/" + contextStr + ".properties");
			if (inContext == null) {
				inContext = TheAvengers_stg.class.getClassLoader()
						.getResourceAsStream("config/contexts/" + contextStr + ".properties");
			}
			if (inContext != null) {
				try {
					// defaultProps is in order to keep the original context value
					if (context != null && context.isEmpty()) {
						defaultProps.load(inContext);
						if (inOSGi && jobProperties != null) {
							java.util.Enumeration<String> keys = jobProperties.keys();
							while (keys.hasMoreElements()) {
								String propKey = keys.nextElement();
								if (defaultProps.containsKey(propKey)) {
									defaultProps.put(propKey, (String) jobProperties.get(propKey));
								}
							}
						}
						context = new ContextProperties(defaultProps);
					}
				} finally {
					inContext.close();
				}
			} else if (!isDefaultContext) {
				// print info and job continue to run, for case: context_param is not empty.
				System.err.println("Could not find the context " + contextStr);
			}

			if (!context_param.isEmpty()) {
				context.putAll(context_param);
				// set types for params from parentJobs
				for (Object key : context_param.keySet()) {
					String context_key = key.toString();
					String context_type = context_param.getContextType(context_key);
					context.setContextType(context_key, context_type);

				}
			}
			class ContextProcessing {
				private void processContext_0() {
					context.setContextType("TheAvengers_File", "id_File");
					if (context.getStringValue("TheAvengers_File") == null) {
						context.TheAvengers_File = null;
					} else {
						context.TheAvengers_File = (String) context.getProperty("TheAvengers_File");
					}
					context.setContextType("TheAvengers_Encoding", "id_String");
					if (context.getStringValue("TheAvengers_Encoding") == null) {
						context.TheAvengers_Encoding = null;
					} else {
						context.TheAvengers_Encoding = (String) context.getProperty("TheAvengers_Encoding");
					}
					context.setContextType("TheAvengers_RowSeparator", "id_String");
					if (context.getStringValue("TheAvengers_RowSeparator") == null) {
						context.TheAvengers_RowSeparator = null;
					} else {
						context.TheAvengers_RowSeparator = (String) context.getProperty("TheAvengers_RowSeparator");
					}
					context.setContextType("TheAvengers_FieldSeparator", "id_String");
					if (context.getStringValue("TheAvengers_FieldSeparator") == null) {
						context.TheAvengers_FieldSeparator = null;
					} else {
						context.TheAvengers_FieldSeparator = (String) context.getProperty("TheAvengers_FieldSeparator");
					}
					context.setContextType("TheAvengers_Header", "id_Integer");
					if (context.getStringValue("TheAvengers_Header") == null) {
						context.TheAvengers_Header = null;
					} else {
						try {
							context.TheAvengers_Header = routines.system.ParserUtils
									.parseTo_Integer(context.getProperty("TheAvengers_Header"));
						} catch (NumberFormatException e) {
							log.warn(String.format("Null value will be used for context parameter %s: %s",
									"TheAvengers_Header", e.getMessage()));
							context.TheAvengers_Header = null;
						}
					}
					context.setContextType("imdb_Port", "id_String");
					if (context.getStringValue("imdb_Port") == null) {
						context.imdb_Port = null;
					} else {
						context.imdb_Port = (String) context.getProperty("imdb_Port");
					}
					context.setContextType("imdb_Database", "id_String");
					if (context.getStringValue("imdb_Database") == null) {
						context.imdb_Database = null;
					} else {
						context.imdb_Database = (String) context.getProperty("imdb_Database");
					}
					context.setContextType("imdb_Password", "id_Password");
					if (context.getStringValue("imdb_Password") == null) {
						context.imdb_Password = null;
					} else {
						String pwd_imdb_Password_value = context.getProperty("imdb_Password");
						context.imdb_Password = null;
						if (pwd_imdb_Password_value != null) {
							if (context_param.containsKey("imdb_Password")) {// no need to decrypt if it come from
																				// program argument or parent job
																				// runtime
								context.imdb_Password = pwd_imdb_Password_value;
							} else if (!pwd_imdb_Password_value.isEmpty()) {
								try {
									context.imdb_Password = routines.system.PasswordEncryptUtil
											.decryptPassword(pwd_imdb_Password_value);
									context.put("imdb_Password", context.imdb_Password);
								} catch (java.lang.RuntimeException e) {
									// do nothing
								}
							}
						}
					}
					context.setContextType("imdb_Login", "id_String");
					if (context.getStringValue("imdb_Login") == null) {
						context.imdb_Login = null;
					} else {
						context.imdb_Login = (String) context.getProperty("imdb_Login");
					}
					context.setContextType("imdb_Server", "id_String");
					if (context.getStringValue("imdb_Server") == null) {
						context.imdb_Server = null;
					} else {
						context.imdb_Server = (String) context.getProperty("imdb_Server");
					}
					context.setContextType("imdb_AdditionalParams", "id_String");
					if (context.getStringValue("imdb_AdditionalParams") == null) {
						context.imdb_AdditionalParams = null;
					} else {
						context.imdb_AdditionalParams = (String) context.getProperty("imdb_AdditionalParams");
					}
				}

				public void processAllContext() {
					processContext_0();
				}
			}

			new ContextProcessing().processAllContext();
		} catch (java.io.IOException ie) {
			System.err.println("Could not load context " + contextStr);
			ie.printStackTrace();
		}

		// get context value from parent directly
		if (parentContextMap != null && !parentContextMap.isEmpty()) {
			if (parentContextMap.containsKey("TheAvengers_File")) {
				context.TheAvengers_File = (String) parentContextMap.get("TheAvengers_File");
			}
			if (parentContextMap.containsKey("TheAvengers_Encoding")) {
				context.TheAvengers_Encoding = (String) parentContextMap.get("TheAvengers_Encoding");
			}
			if (parentContextMap.containsKey("TheAvengers_RowSeparator")) {
				context.TheAvengers_RowSeparator = (String) parentContextMap.get("TheAvengers_RowSeparator");
			}
			if (parentContextMap.containsKey("TheAvengers_FieldSeparator")) {
				context.TheAvengers_FieldSeparator = (String) parentContextMap.get("TheAvengers_FieldSeparator");
			}
			if (parentContextMap.containsKey("TheAvengers_Header")) {
				context.TheAvengers_Header = (Integer) parentContextMap.get("TheAvengers_Header");
			}
			if (parentContextMap.containsKey("imdb_Port")) {
				context.imdb_Port = (String) parentContextMap.get("imdb_Port");
			}
			if (parentContextMap.containsKey("imdb_Database")) {
				context.imdb_Database = (String) parentContextMap.get("imdb_Database");
			}
			if (parentContextMap.containsKey("imdb_Password")) {
				context.imdb_Password = (java.lang.String) parentContextMap.get("imdb_Password");
			}
			if (parentContextMap.containsKey("imdb_Login")) {
				context.imdb_Login = (String) parentContextMap.get("imdb_Login");
			}
			if (parentContextMap.containsKey("imdb_Server")) {
				context.imdb_Server = (String) parentContextMap.get("imdb_Server");
			}
			if (parentContextMap.containsKey("imdb_AdditionalParams")) {
				context.imdb_AdditionalParams = (String) parentContextMap.get("imdb_AdditionalParams");
			}
		}

		// Resume: init the resumeUtil
		resumeEntryMethodName = ResumeUtil.getResumeEntryMethodName(resuming_checkpoint_path);
		resumeUtil = new ResumeUtil(resuming_logs_dir_path, isChildJob, rootPid);
		resumeUtil.initCommonInfo(pid, rootPid, fatherPid, projectName, jobName, contextStr, jobVersion);

		List<String> parametersToEncrypt = new java.util.ArrayList<String>();
		parametersToEncrypt.add("imdb_Password");
		// Resume: jobStart
		resumeUtil.addLog("JOB_STARTED", "JOB:" + jobName, parent_part_launcher, Thread.currentThread().getId() + "",
				"", "", "", "", resumeUtil.convertToJsonText(context, ContextProperties.class, parametersToEncrypt));

		org.slf4j.MDC.put("_context", contextStr);
		log.info("TalendJob: 'TheAvengers_stg' - Started.");
		java.util.Optional.ofNullable(org.slf4j.MDC.getCopyOfContextMap()).ifPresent(mdcInfo::putAll);

		if (execStat) {
			try {
				runStat.openSocket(!isChildJob);
				runStat.setAllPID(rootPid, fatherPid, pid, jobName);
				runStat.startThreadStat(clientHost, portStats);
				runStat.updateStatOnJob(RunStat.JOBSTART, fatherNode);
			} catch (java.io.IOException ioException) {
				ioException.printStackTrace();
			}
		}

		java.util.concurrent.ConcurrentHashMap<Object, Object> concurrentHashMap = new java.util.concurrent.ConcurrentHashMap<Object, Object>();
		globalMap.put("concurrentHashMap", concurrentHashMap);

		long startUsedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		long endUsedMemory = 0;
		long end = 0;

		startTime = System.currentTimeMillis();

		this.globalResumeTicket = true;// to run tPreJob

		if (enableLogStash) {
			talendJobLog.addJobStartMessage();
			try {
				talendJobLogProcess(globalMap);
			} catch (java.lang.Exception e) {
				e.printStackTrace();
			}
		}

		this.globalResumeTicket = false;// to run others jobs

		try {
			errorCode = null;
			tFileInputDelimited_1Process(globalMap);
			if (!"failure".equals(status)) {
				status = "end";
			}
		} catch (TalendException e_tFileInputDelimited_1) {
			globalMap.put("tFileInputDelimited_1_SUBPROCESS_STATE", -1);

			e_tFileInputDelimited_1.printStackTrace();

		}

		this.globalResumeTicket = true;// to run tPostJob

		end = System.currentTimeMillis();

		if (watch) {
			System.out.println((end - startTime) + " milliseconds");
		}

		endUsedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		if (false) {
			System.out.println(
					(endUsedMemory - startUsedMemory) + " bytes memory increase when running : TheAvengers_stg");
		}
		if (enableLogStash) {
			talendJobLog.addJobEndMessage(startTime, end, status);
			try {
				talendJobLogProcess(globalMap);
			} catch (java.lang.Exception e) {
				e.printStackTrace();
			}
		}

		if (execStat) {
			runStat.updateStatOnJob(RunStat.JOBEND, fatherNode);
			runStat.stopThreadStat();
		}
		int returnCode = 0;

		if (errorCode == null) {
			returnCode = status != null && status.equals("failure") ? 1 : 0;
		} else {
			returnCode = errorCode.intValue();
		}
		resumeUtil.addLog("JOB_ENDED", "JOB:" + jobName, parent_part_launcher, Thread.currentThread().getId() + "", "",
				"" + returnCode, "", "", "");
		resumeUtil.flush();

		org.slf4j.MDC.remove("_subJobName");
		org.slf4j.MDC.remove("_subJobPid");
		org.slf4j.MDC.remove("_systemPid");
		log.info("TalendJob: 'TheAvengers_stg' - Finished - status: " + status + " returnCode: " + returnCode);

		return returnCode;

	}

	// only for OSGi env
	public void destroy() {

	}

	private java.util.Map<String, Object> getSharedConnections4REST() {
		java.util.Map<String, Object> connections = new java.util.HashMap<String, Object>();

		return connections;
	}

	private void evalParam(String arg) {
		if (arg.startsWith("--resuming_logs_dir_path")) {
			resuming_logs_dir_path = arg.substring(25);
		} else if (arg.startsWith("--resuming_checkpoint_path")) {
			resuming_checkpoint_path = arg.substring(27);
		} else if (arg.startsWith("--parent_part_launcher")) {
			parent_part_launcher = arg.substring(23);
		} else if (arg.startsWith("--watch")) {
			watch = true;
		} else if (arg.startsWith("--stat_port=")) {
			String portStatsStr = arg.substring(12);
			if (portStatsStr != null && !portStatsStr.equals("null")) {
				portStats = Integer.parseInt(portStatsStr);
			}
		} else if (arg.startsWith("--trace_port=")) {
			portTraces = Integer.parseInt(arg.substring(13));
		} else if (arg.startsWith("--client_host=")) {
			clientHost = arg.substring(14);
		} else if (arg.startsWith("--context=")) {
			contextStr = arg.substring(10);
			isDefaultContext = false;
		} else if (arg.startsWith("--father_pid=")) {
			fatherPid = arg.substring(13);
		} else if (arg.startsWith("--root_pid=")) {
			rootPid = arg.substring(11);
		} else if (arg.startsWith("--father_node=")) {
			fatherNode = arg.substring(14);
		} else if (arg.startsWith("--pid=")) {
			pid = arg.substring(6);
		} else if (arg.startsWith("--context_type")) {
			String keyValue = arg.substring(15);
			int index = -1;
			if (keyValue != null && (index = keyValue.indexOf('=')) > -1) {
				if (fatherPid == null) {
					context_param.setContextType(keyValue.substring(0, index),
							replaceEscapeChars(keyValue.substring(index + 1)));
				} else { // the subjob won't escape the especial chars
					context_param.setContextType(keyValue.substring(0, index), keyValue.substring(index + 1));
				}

			}

		} else if (arg.startsWith("--context_param")) {
			String keyValue = arg.substring(16);
			int index = -1;
			if (keyValue != null && (index = keyValue.indexOf('=')) > -1) {
				if (fatherPid == null) {
					context_param.put(keyValue.substring(0, index), replaceEscapeChars(keyValue.substring(index + 1)));
				} else { // the subjob won't escape the especial chars
					context_param.put(keyValue.substring(0, index), keyValue.substring(index + 1));
				}
			}
		} else if (arg.startsWith("--context_file")) {
			String keyValue = arg.substring(15);
			String filePath = new String(java.util.Base64.getDecoder().decode(keyValue));
			java.nio.file.Path contextFile = java.nio.file.Paths.get(filePath);
			try (java.io.BufferedReader reader = java.nio.file.Files.newBufferedReader(contextFile)) {
				String line;
				while ((line = reader.readLine()) != null) {
					int index = -1;
					if ((index = line.indexOf('=')) > -1) {
						if (line.startsWith("--context_param")) {
							if ("id_Password".equals(context_param.getContextType(line.substring(16, index)))) {
								context_param.put(line.substring(16, index),
										routines.system.PasswordEncryptUtil.decryptPassword(line.substring(index + 1)));
							} else {
								context_param.put(line.substring(16, index), line.substring(index + 1));
							}
						} else {// --context_type
							context_param.setContextType(line.substring(15, index), line.substring(index + 1));
						}
					}
				}
			} catch (java.io.IOException e) {
				System.err.println("Could not load the context file: " + filePath);
				e.printStackTrace();
			}
		} else if (arg.startsWith("--log4jLevel=")) {
			log4jLevel = arg.substring(13);
		} else if (arg.startsWith("--audit.enabled") && arg.contains("=")) {// for trunjob call
			final int equal = arg.indexOf('=');
			final String key = arg.substring("--".length(), equal);
			System.setProperty(key, arg.substring(equal + 1));
		}
	}

	private static final String NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY = "<TALEND_NULL>";

	private final String[][] escapeChars = { { "\\\\", "\\" }, { "\\n", "\n" }, { "\\'", "\'" }, { "\\r", "\r" },
			{ "\\f", "\f" }, { "\\b", "\b" }, { "\\t", "\t" } };

	private String replaceEscapeChars(String keyValue) {

		if (keyValue == null || ("").equals(keyValue.trim())) {
			return keyValue;
		}

		StringBuilder result = new StringBuilder();
		int currIndex = 0;
		while (currIndex < keyValue.length()) {
			int index = -1;
			// judege if the left string includes escape chars
			for (String[] strArray : escapeChars) {
				index = keyValue.indexOf(strArray[0], currIndex);
				if (index >= 0) {

					result.append(keyValue.substring(currIndex, index + strArray[0].length()).replace(strArray[0],
							strArray[1]));
					currIndex = index + strArray[0].length();
					break;
				}
			}
			// if the left string doesn't include escape chars, append the left into the
			// result
			if (index < 0) {
				result.append(keyValue.substring(currIndex));
				currIndex = currIndex + keyValue.length();
			}
		}

		return result.toString();
	}

	public Integer getErrorCode() {
		return errorCode;
	}

	public String getStatus() {
		return status;
	}

	ResumeUtil resumeUtil = null;
}
/************************************************************************************************
 * 129888 characters generated by Talend Cloud Data Fabric on the December 2,
 * 2023 at 9:12:51 PM EST
 ************************************************************************************************/
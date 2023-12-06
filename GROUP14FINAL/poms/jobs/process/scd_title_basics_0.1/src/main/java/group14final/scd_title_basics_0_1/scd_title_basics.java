
package group14final.scd_title_basics_0_1;

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
 * Job: scd_title_basics Purpose: <br>
 * Description: <br>
 * 
 * @author jain.harshj@northeastern.edu
 * @version 8.0.1.20231116_0906-patch
 * @status
 */
public class scd_title_basics implements TalendJob {
	static {
		System.setProperty("TalendJob.log", "scd_title_basics.log");
	}

	private static org.apache.logging.log4j.Logger log = org.apache.logging.log4j.LogManager
			.getLogger(scd_title_basics.class);

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

			if (str_title_basics != null) {

				this.setProperty("str_title_basics", str_title_basics.toString());

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

		public String str_title_basics;

		public String getStr_title_basics() {
			return this.str_title_basics;
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
	private final String jobName = "scd_title_basics";
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
			"_6pgfIJIkEe63wpxH0JsEEw", "0.1");
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
					scd_title_basics.this.exception = e;
				}
			}
			if (!(e instanceof TalendException)) {
				try {
					for (java.lang.reflect.Method m : this.getClass().getEnclosingClass().getMethods()) {
						if (m.getName().compareTo(currentComponent + "_error") == 0) {
							m.invoke(scd_title_basics.this, new Object[] { e, currentComponent, globalMap });
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

	public void tDBRow_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBRow_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tFileList_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFileList_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tFileInputJSON_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFileList_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tMap_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFileList_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDBSCD_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFileList_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void talendJobLog_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		talendJobLog_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDBRow_1_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public void tFileList_1_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public void talendJobLog_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public void tDBRow_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tDBRow_1_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		mdcInfo.forEach(org.slf4j.MDC::put);
		org.slf4j.MDC.put("_subJobName", "tDBRow_1");
		org.slf4j.MDC.put("_subJobPid", "jyptXV_" + subJobPidCounter.getAndIncrement());

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
				 * [tDBRow_1 begin ] start
				 */

				ok_Hash.put("tDBRow_1", false);
				start_Hash.put("tDBRow_1", System.currentTimeMillis());

				currentComponent = "tDBRow_1";

				cLabel = "\"scd_title_basics\"";

				int tos_count_tDBRow_1 = 0;

				if (log.isDebugEnabled())
					log.debug("tDBRow_1 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tDBRow_1 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tDBRow_1 = new StringBuilder();
							log4jParamters_tDBRow_1.append("Parameters:");
							log4jParamters_tDBRow_1.append("DB_VERSION" + " = " + "MYSQL_8");
							log4jParamters_tDBRow_1.append(" | ");
							log4jParamters_tDBRow_1.append("USE_EXISTING_CONNECTION" + " = " + "false");
							log4jParamters_tDBRow_1.append(" | ");
							log4jParamters_tDBRow_1.append("HOST" + " = " + "context.imdb_Server");
							log4jParamters_tDBRow_1.append(" | ");
							log4jParamters_tDBRow_1.append("PORT" + " = " + "context.imdb_Port");
							log4jParamters_tDBRow_1.append(" | ");
							log4jParamters_tDBRow_1.append("DBNAME" + " = " + "context.imdb_Database");
							log4jParamters_tDBRow_1.append(" | ");
							log4jParamters_tDBRow_1.append("USER" + " = " + "context.imdb_Login");
							log4jParamters_tDBRow_1.append(" | ");
							log4jParamters_tDBRow_1.append("PASS" + " = "
									+ String.valueOf(
											routines.system.PasswordEncryptUtil.encryptPassword(context.imdb_Password))
											.substring(0, 4)
									+ "...");
							log4jParamters_tDBRow_1.append(" | ");
							log4jParamters_tDBRow_1.append("QUERYSTORE" + " = " + "\"\"");
							log4jParamters_tDBRow_1.append(" | ");
							log4jParamters_tDBRow_1.append("QUERY" + " = "
									+ "\"SELECT    `scd_title_basics`.`tconst`,    `scd_title_basics`.`titleType`,    `scd_title_basics`.`primaryTitle`,    `scd_title_basics`.`originalTitle`,    `scd_title_basics`.`isAdult`,    `scd_title_basics`.`startYear`,    `scd_title_basics`.`endYear`,    `scd_title_basics`.`runtimeMinutes`,    `scd_title_basics`.`genres` FROM `scd_title_basics`\"");
							log4jParamters_tDBRow_1.append(" | ");
							log4jParamters_tDBRow_1.append("SPECIFY_DATASOURCE_ALIAS" + " = " + "false");
							log4jParamters_tDBRow_1.append(" | ");
							log4jParamters_tDBRow_1.append("DIE_ON_ERROR" + " = " + "false");
							log4jParamters_tDBRow_1.append(" | ");
							log4jParamters_tDBRow_1.append("PROPERTIES" + " = " + "context.imdb_AdditionalParams");
							log4jParamters_tDBRow_1.append(" | ");
							log4jParamters_tDBRow_1.append("PROPAGATE_RECORD_SET" + " = " + "false");
							log4jParamters_tDBRow_1.append(" | ");
							log4jParamters_tDBRow_1.append("USE_PREPAREDSTATEMENT" + " = " + "false");
							log4jParamters_tDBRow_1.append(" | ");
							log4jParamters_tDBRow_1.append("COMMIT_EVERY" + " = " + "10000");
							log4jParamters_tDBRow_1.append(" | ");
							log4jParamters_tDBRow_1.append("UNIFIED_COMPONENTS" + " = " + "tMysqlRow");
							log4jParamters_tDBRow_1.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tDBRow_1 - " + (log4jParamters_tDBRow_1));
						}
					}
					new BytesLimit65535_tDBRow_1().limitLog4jByte();
				}
				if (enableLogStash) {
					talendJobLog.addCM("tDBRow_1", "\"scd_title_basics\"", "tMysqlRow");
					talendJobLogProcess(globalMap);
				}

				java.sql.Connection conn_tDBRow_1 = null;
				String query_tDBRow_1 = "";
				boolean whetherReject_tDBRow_1 = false;
				int count_tDBRow_1 = 0;
				String driverClass_tDBRow_1 = "com.mysql.cj.jdbc.Driver";
				java.lang.Class jdbcclazz_tDBRow_1 = java.lang.Class.forName(driverClass_tDBRow_1);

				String properties_tDBRow_1 = context.imdb_AdditionalParams;
				if (properties_tDBRow_1 == null || properties_tDBRow_1.trim().length() == 0) {
					properties_tDBRow_1 = "allowLoadLocalInfile=true";
				} else {
					if (!properties_tDBRow_1.contains("allowLoadLocalInfile=")) {
						properties_tDBRow_1 += "&allowLoadLocalInfile=true";
					}
				}

				String url_tDBRow_1 = "jdbc:mysql://" + context.imdb_Server + ":" + context.imdb_Port + "/"
						+ context.imdb_Database + "?" + properties_tDBRow_1;
				log.debug("tDBRow_1 - Driver ClassName: " + driverClass_tDBRow_1 + ".");

				String dbUser_tDBRow_1 = context.imdb_Login;

				final String decryptedPassword_tDBRow_1 = context.imdb_Password;

				String dbPwd_tDBRow_1 = decryptedPassword_tDBRow_1;

				log.debug("tDBRow_1 - Connection attempt to '" + url_tDBRow_1 + "' with the username '"
						+ dbUser_tDBRow_1 + "'.");

				conn_tDBRow_1 = java.sql.DriverManager.getConnection(url_tDBRow_1, dbUser_tDBRow_1, dbPwd_tDBRow_1);

				log.debug("tDBRow_1 - Connection to '" + url_tDBRow_1 + "' has succeeded.");

				resourceMap.put("conn_tDBRow_1", conn_tDBRow_1);
				if (conn_tDBRow_1.getAutoCommit()) {

					log.debug("tDBRow_1 - Connection is set auto commit to 'false'.");

					conn_tDBRow_1.setAutoCommit(false);

				}
				int commitEvery_tDBRow_1 = 10000;
				int commitCounter_tDBRow_1 = 0;

				java.sql.Statement stmt_tDBRow_1 = conn_tDBRow_1.createStatement();
				resourceMap.put("stmt_tDBRow_1", stmt_tDBRow_1);

				/**
				 * [tDBRow_1 begin ] stop
				 */

				/**
				 * [tDBRow_1 main ] start
				 */

				currentComponent = "tDBRow_1";

				cLabel = "\"scd_title_basics\"";

				query_tDBRow_1 = "SELECT \n  `scd_title_basics`.`tconst`, \n  `scd_title_basics`.`titleType`, \n  `scd_title_basics`.`primaryTitle`, \n  `scd"
						+ "_title_basics`.`originalTitle`, \n  `scd_title_basics`.`isAdult`, \n  `scd_title_basics`.`startYear`, \n  `scd_title_basics"
						+ "`.`endYear`, \n  `scd_title_basics`.`runtimeMinutes`, \n  `scd_title_basics`.`genres`\nFROM `scd_title_basics`";
				whetherReject_tDBRow_1 = false;
				log.debug("tDBRow_1 - Executing the query: '" + query_tDBRow_1 + "'.");

				globalMap.put("tDBRow_1_QUERY", query_tDBRow_1);
				try {
					stmt_tDBRow_1.execute(query_tDBRow_1);
					log.debug("tDBRow_1 - Execute the query: '" + query_tDBRow_1 + "' has finished.");

				} catch (java.lang.Exception e) {
					whetherReject_tDBRow_1 = true;

					log.error("tDBRow_1 - " + e.getMessage());

					System.err.print(e.getMessage());
					globalMap.put("tDBRow_1_ERROR_MESSAGE", e.getMessage());

				}

				commitCounter_tDBRow_1++;
				if (commitEvery_tDBRow_1 <= commitCounter_tDBRow_1) {

					log.debug("tDBRow_1 - Connection starting to commit.");

					conn_tDBRow_1.commit();

					log.debug("tDBRow_1 - Connection commit has succeeded.");

					commitCounter_tDBRow_1 = 0;
				}

				tos_count_tDBRow_1++;

				/**
				 * [tDBRow_1 main ] stop
				 */

				/**
				 * [tDBRow_1 process_data_begin ] start
				 */

				currentComponent = "tDBRow_1";

				cLabel = "\"scd_title_basics\"";

				/**
				 * [tDBRow_1 process_data_begin ] stop
				 */

				/**
				 * [tDBRow_1 process_data_end ] start
				 */

				currentComponent = "tDBRow_1";

				cLabel = "\"scd_title_basics\"";

				/**
				 * [tDBRow_1 process_data_end ] stop
				 */

				/**
				 * [tDBRow_1 end ] start
				 */

				currentComponent = "tDBRow_1";

				cLabel = "\"scd_title_basics\"";

				globalMap.put("tDBRow_1_NB_LINE", count_tDBRow_1);
				stmt_tDBRow_1.close();
				resourceMap.remove("stmt_tDBRow_1");
				resourceMap.put("statementClosed_tDBRow_1", true);
				if (commitEvery_tDBRow_1 > commitCounter_tDBRow_1) {

					log.debug("tDBRow_1 - Connection starting to commit.");

					conn_tDBRow_1.commit();

					log.debug("tDBRow_1 - Connection commit has succeeded.");

					commitCounter_tDBRow_1 = 0;

				}
				log.debug("tDBRow_1 - Closing the connection to the database.");

				conn_tDBRow_1.close();

				if ("com.mysql.cj.jdbc.Driver".equals((String) globalMap.get("driverClass_"))
						&& routines.system.BundleUtils.inOSGi()) {
					Class.forName("com.mysql.cj.jdbc.AbandonedConnectionCleanupThread").getMethod("checkedShutdown")
							.invoke(null, (Object[]) null);
				}

				log.debug("tDBRow_1 - Connection to the database closed.");

				resourceMap.put("finish_tDBRow_1", true);

				if (log.isDebugEnabled())
					log.debug("tDBRow_1 - " + ("Done."));

				ok_Hash.put("tDBRow_1", true);
				end_Hash.put("tDBRow_1", System.currentTimeMillis());

				/**
				 * [tDBRow_1 end ] stop
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
				 * [tDBRow_1 finally ] start
				 */

				currentComponent = "tDBRow_1";

				cLabel = "\"scd_title_basics\"";

				try {
					if (resourceMap.get("statementClosed_tDBRow_1") == null) {
						java.sql.Statement stmtToClose_tDBRow_1 = null;
						if ((stmtToClose_tDBRow_1 = (java.sql.Statement) resourceMap.remove("stmt_tDBRow_1")) != null) {
							stmtToClose_tDBRow_1.close();
						}
					}
				} finally {
					if (resourceMap.get("finish_tDBRow_1") == null) {
						java.sql.Connection ctn_tDBRow_1 = null;
						if ((ctn_tDBRow_1 = (java.sql.Connection) resourceMap.get("conn_tDBRow_1")) != null) {
							try {
								log.debug("tDBRow_1 - Closing the connection to the database.");

								ctn_tDBRow_1.close();
								log.debug("tDBRow_1 - Connection to the database closed.");

							} catch (java.sql.SQLException sqlEx_tDBRow_1) {
								String errorMessage_tDBRow_1 = "failed to close the connection in tDBRow_1 :"
										+ sqlEx_tDBRow_1.getMessage();
								log.error("tDBRow_1 - " + sqlEx_tDBRow_1.getMessage());

								System.err.println(errorMessage_tDBRow_1);
							}
						}
					}
				}

				/**
				 * [tDBRow_1 finally ] stop
				 */
			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tDBRow_1_SUBPROCESS_STATE", 1);
	}

	public static class opStruct implements routines.system.IPersistableRow<opStruct> {
		final static byte[] commonByteArrayLock_GROUP14FINAL_scd_title_basics = new byte[0];
		static byte[] commonByteArray_GROUP14FINAL_scd_title_basics = new byte[0];
		protected static final int DEFAULT_HASHCODE = 1;
		protected static final int PRIME = 31;
		protected int hashCode = DEFAULT_HASHCODE;
		public boolean hashCodeDirty = true;

		public String loopKey;

		public String tconst;

		public String getTconst() {
			return this.tconst;
		}

		public Boolean tconstIsNullable() {
			return false;
		}

		public Boolean tconstIsKey() {
			return true;
		}

		public Integer tconstLength() {
			return 10;
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

		public String titleType;

		public String getTitleType() {
			return this.titleType;
		}

		public Boolean titleTypeIsNullable() {
			return true;
		}

		public Boolean titleTypeIsKey() {
			return false;
		}

		public Integer titleTypeLength() {
			return 255;
		}

		public Integer titleTypePrecision() {
			return 0;
		}

		public String titleTypeDefault() {

			return null;

		}

		public String titleTypeComment() {

			return "";

		}

		public String titleTypePattern() {

			return "";

		}

		public String titleTypeOriginalDbColumnName() {

			return "titleType";

		}

		public String primaryTitle;

		public String getPrimaryTitle() {
			return this.primaryTitle;
		}

		public Boolean primaryTitleIsNullable() {
			return true;
		}

		public Boolean primaryTitleIsKey() {
			return false;
		}

		public Integer primaryTitleLength() {
			return 1024;
		}

		public Integer primaryTitlePrecision() {
			return 0;
		}

		public String primaryTitleDefault() {

			return null;

		}

		public String primaryTitleComment() {

			return "";

		}

		public String primaryTitlePattern() {

			return "";

		}

		public String primaryTitleOriginalDbColumnName() {

			return "primaryTitle";

		}

		public String originalTitle;

		public String getOriginalTitle() {
			return this.originalTitle;
		}

		public Boolean originalTitleIsNullable() {
			return true;
		}

		public Boolean originalTitleIsKey() {
			return false;
		}

		public Integer originalTitleLength() {
			return 1024;
		}

		public Integer originalTitlePrecision() {
			return 0;
		}

		public String originalTitleDefault() {

			return null;

		}

		public String originalTitleComment() {

			return "";

		}

		public String originalTitlePattern() {

			return "";

		}

		public String originalTitleOriginalDbColumnName() {

			return "originalTitle";

		}

		public Byte isAdult;

		public Byte getIsAdult() {
			return this.isAdult;
		}

		public Boolean isAdultIsNullable() {
			return true;
		}

		public Boolean isAdultIsKey() {
			return false;
		}

		public Integer isAdultLength() {
			return 3;
		}

		public Integer isAdultPrecision() {
			return 0;
		}

		public String isAdultDefault() {

			return null;

		}

		public String isAdultComment() {

			return "";

		}

		public String isAdultPattern() {

			return "";

		}

		public String isAdultOriginalDbColumnName() {

			return "isAdult";

		}

		public String startYear;

		public String getStartYear() {
			return this.startYear;
		}

		public Boolean startYearIsNullable() {
			return true;
		}

		public Boolean startYearIsKey() {
			return false;
		}

		public Integer startYearLength() {
			return 4;
		}

		public Integer startYearPrecision() {
			return 0;
		}

		public String startYearDefault() {

			return null;

		}

		public String startYearComment() {

			return "";

		}

		public String startYearPattern() {

			return "";

		}

		public String startYearOriginalDbColumnName() {

			return "startYear";

		}

		public String endYear;

		public String getEndYear() {
			return this.endYear;
		}

		public Boolean endYearIsNullable() {
			return true;
		}

		public Boolean endYearIsKey() {
			return false;
		}

		public Integer endYearLength() {
			return 4;
		}

		public Integer endYearPrecision() {
			return 0;
		}

		public String endYearDefault() {

			return null;

		}

		public String endYearComment() {

			return "";

		}

		public String endYearPattern() {

			return "";

		}

		public String endYearOriginalDbColumnName() {

			return "endYear";

		}

		public String runtimeMinutes;

		public String getRuntimeMinutes() {
			return this.runtimeMinutes;
		}

		public Boolean runtimeMinutesIsNullable() {
			return true;
		}

		public Boolean runtimeMinutesIsKey() {
			return false;
		}

		public Integer runtimeMinutesLength() {
			return 10;
		}

		public Integer runtimeMinutesPrecision() {
			return 0;
		}

		public String runtimeMinutesDefault() {

			return null;

		}

		public String runtimeMinutesComment() {

			return "";

		}

		public String runtimeMinutesPattern() {

			return "";

		}

		public String runtimeMinutesOriginalDbColumnName() {

			return "runtimeMinutes";

		}

		public String genres;

		public String getGenres() {
			return this.genres;
		}

		public Boolean genresIsNullable() {
			return true;
		}

		public Boolean genresIsKey() {
			return false;
		}

		public Integer genresLength() {
			return 255;
		}

		public Integer genresPrecision() {
			return 0;
		}

		public String genresDefault() {

			return null;

		}

		public String genresComment() {

			return "";

		}

		public String genresPattern() {

			return "";

		}

		public String genresOriginalDbColumnName() {

			return "genres";

		}

		public java.util.Date DI_Created_Date;

		public java.util.Date getDI_Created_Date() {
			return this.DI_Created_Date;
		}

		public Boolean DI_Created_DateIsNullable() {
			return true;
		}

		public Boolean DI_Created_DateIsKey() {
			return false;
		}

		public Integer DI_Created_DateLength() {
			return 10;
		}

		public Integer DI_Created_DatePrecision() {
			return 0;
		}

		public String DI_Created_DateDefault() {

			return null;

		}

		public String DI_Created_DateComment() {

			return "";

		}

		public String DI_Created_DatePattern() {

			return "dd-MM-yyyy";

		}

		public String DI_Created_DateOriginalDbColumnName() {

			return "DI_Created_Date";

		}

		public String DI_JobId;

		public String getDI_JobId() {
			return this.DI_JobId;
		}

		public Boolean DI_JobIdIsNullable() {
			return true;
		}

		public Boolean DI_JobIdIsKey() {
			return false;
		}

		public Integer DI_JobIdLength() {
			return 10;
		}

		public Integer DI_JobIdPrecision() {
			return 0;
		}

		public String DI_JobIdDefault() {

			return null;

		}

		public String DI_JobIdComment() {

			return "";

		}

		public String DI_JobIdPattern() {

			return "";

		}

		public String DI_JobIdOriginalDbColumnName() {

			return "DI_JobId";

		}

		@Override
		public int hashCode() {
			if (this.hashCodeDirty) {
				final int prime = PRIME;
				int result = DEFAULT_HASHCODE;

				result = prime * result + ((this.tconst == null) ? 0 : this.tconst.hashCode());

				this.hashCode = result;
				this.hashCodeDirty = false;
			}
			return this.hashCode;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			final opStruct other = (opStruct) obj;

			if (this.tconst == null) {
				if (other.tconst != null)
					return false;

			} else if (!this.tconst.equals(other.tconst))

				return false;

			return true;
		}

		public void copyDataTo(opStruct other) {

			other.tconst = this.tconst;
			other.titleType = this.titleType;
			other.primaryTitle = this.primaryTitle;
			other.originalTitle = this.originalTitle;
			other.isAdult = this.isAdult;
			other.startYear = this.startYear;
			other.endYear = this.endYear;
			other.runtimeMinutes = this.runtimeMinutes;
			other.genres = this.genres;
			other.DI_Created_Date = this.DI_Created_Date;
			other.DI_JobId = this.DI_JobId;

		}

		public void copyKeysDataTo(opStruct other) {

			other.tconst = this.tconst;

		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_GROUP14FINAL_scd_title_basics.length) {
					if (length < 1024 && commonByteArray_GROUP14FINAL_scd_title_basics.length == 0) {
						commonByteArray_GROUP14FINAL_scd_title_basics = new byte[1024];
					} else {
						commonByteArray_GROUP14FINAL_scd_title_basics = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_GROUP14FINAL_scd_title_basics, 0, length);
				strReturn = new String(commonByteArray_GROUP14FINAL_scd_title_basics, 0, length, utf8Charset);
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
				if (length > commonByteArray_GROUP14FINAL_scd_title_basics.length) {
					if (length < 1024 && commonByteArray_GROUP14FINAL_scd_title_basics.length == 0) {
						commonByteArray_GROUP14FINAL_scd_title_basics = new byte[1024];
					} else {
						commonByteArray_GROUP14FINAL_scd_title_basics = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_GROUP14FINAL_scd_title_basics, 0, length);
				strReturn = new String(commonByteArray_GROUP14FINAL_scd_title_basics, 0, length, utf8Charset);
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

		private java.util.Date readDate(ObjectInputStream dis) throws IOException {
			java.util.Date dateReturn = null;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				dateReturn = null;
			} else {
				dateReturn = new Date(dis.readLong());
			}
			return dateReturn;
		}

		private java.util.Date readDate(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			java.util.Date dateReturn = null;
			int length = 0;
			length = unmarshaller.readByte();
			if (length == -1) {
				dateReturn = null;
			} else {
				dateReturn = new Date(unmarshaller.readLong());
			}
			return dateReturn;
		}

		private void writeDate(java.util.Date date1, ObjectOutputStream dos) throws IOException {
			if (date1 == null) {
				dos.writeByte(-1);
			} else {
				dos.writeByte(0);
				dos.writeLong(date1.getTime());
			}
		}

		private void writeDate(java.util.Date date1, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (date1 == null) {
				marshaller.writeByte(-1);
			} else {
				marshaller.writeByte(0);
				marshaller.writeLong(date1.getTime());
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_GROUP14FINAL_scd_title_basics) {

				try {

					int length = 0;

					this.tconst = readString(dis);

					this.titleType = readString(dis);

					this.primaryTitle = readString(dis);

					this.originalTitle = readString(dis);

					length = dis.readByte();
					if (length == -1) {
						this.isAdult = null;
					} else {
						this.isAdult = dis.readByte();
					}

					this.startYear = readString(dis);

					this.endYear = readString(dis);

					this.runtimeMinutes = readString(dis);

					this.genres = readString(dis);

					this.DI_Created_Date = readDate(dis);

					this.DI_JobId = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_GROUP14FINAL_scd_title_basics) {

				try {

					int length = 0;

					this.tconst = readString(dis);

					this.titleType = readString(dis);

					this.primaryTitle = readString(dis);

					this.originalTitle = readString(dis);

					length = dis.readByte();
					if (length == -1) {
						this.isAdult = null;
					} else {
						this.isAdult = dis.readByte();
					}

					this.startYear = readString(dis);

					this.endYear = readString(dis);

					this.runtimeMinutes = readString(dis);

					this.genres = readString(dis);

					this.DI_Created_Date = readDate(dis);

					this.DI_JobId = readString(dis);

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

				writeString(this.titleType, dos);

				// String

				writeString(this.primaryTitle, dos);

				// String

				writeString(this.originalTitle, dos);

				// Byte

				if (this.isAdult == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeByte(this.isAdult);
				}

				// String

				writeString(this.startYear, dos);

				// String

				writeString(this.endYear, dos);

				// String

				writeString(this.runtimeMinutes, dos);

				// String

				writeString(this.genres, dos);

				// java.util.Date

				writeDate(this.DI_Created_Date, dos);

				// String

				writeString(this.DI_JobId, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.tconst, dos);

				// String

				writeString(this.titleType, dos);

				// String

				writeString(this.primaryTitle, dos);

				// String

				writeString(this.originalTitle, dos);

				// Byte

				if (this.isAdult == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeByte(this.isAdult);
				}

				// String

				writeString(this.startYear, dos);

				// String

				writeString(this.endYear, dos);

				// String

				writeString(this.runtimeMinutes, dos);

				// String

				writeString(this.genres, dos);

				// java.util.Date

				writeDate(this.DI_Created_Date, dos);

				// String

				writeString(this.DI_JobId, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("tconst=" + tconst);
			sb.append(",titleType=" + titleType);
			sb.append(",primaryTitle=" + primaryTitle);
			sb.append(",originalTitle=" + originalTitle);
			sb.append(",isAdult=" + String.valueOf(isAdult));
			sb.append(",startYear=" + startYear);
			sb.append(",endYear=" + endYear);
			sb.append(",runtimeMinutes=" + runtimeMinutes);
			sb.append(",genres=" + genres);
			sb.append(",DI_Created_Date=" + String.valueOf(DI_Created_Date));
			sb.append(",DI_JobId=" + DI_JobId);
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

			if (titleType == null) {
				sb.append("<null>");
			} else {
				sb.append(titleType);
			}

			sb.append("|");

			if (primaryTitle == null) {
				sb.append("<null>");
			} else {
				sb.append(primaryTitle);
			}

			sb.append("|");

			if (originalTitle == null) {
				sb.append("<null>");
			} else {
				sb.append(originalTitle);
			}

			sb.append("|");

			if (isAdult == null) {
				sb.append("<null>");
			} else {
				sb.append(isAdult);
			}

			sb.append("|");

			if (startYear == null) {
				sb.append("<null>");
			} else {
				sb.append(startYear);
			}

			sb.append("|");

			if (endYear == null) {
				sb.append("<null>");
			} else {
				sb.append(endYear);
			}

			sb.append("|");

			if (runtimeMinutes == null) {
				sb.append("<null>");
			} else {
				sb.append(runtimeMinutes);
			}

			sb.append("|");

			if (genres == null) {
				sb.append("<null>");
			} else {
				sb.append(genres);
			}

			sb.append("|");

			if (DI_Created_Date == null) {
				sb.append("<null>");
			} else {
				sb.append(DI_Created_Date);
			}

			sb.append("|");

			if (DI_JobId == null) {
				sb.append("<null>");
			} else {
				sb.append(DI_JobId);
			}

			sb.append("|");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(opStruct other) {

			int returnValue = -1;

			returnValue = checkNullsAndCompare(this.tconst, other.tconst);
			if (returnValue != 0) {
				return returnValue;
			}

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
		final static byte[] commonByteArrayLock_GROUP14FINAL_scd_title_basics = new byte[0];
		static byte[] commonByteArray_GROUP14FINAL_scd_title_basics = new byte[0];

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
			return 10;
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

		public String titleType;

		public String getTitleType() {
			return this.titleType;
		}

		public Boolean titleTypeIsNullable() {
			return true;
		}

		public Boolean titleTypeIsKey() {
			return false;
		}

		public Integer titleTypeLength() {
			return 5;
		}

		public Integer titleTypePrecision() {
			return 0;
		}

		public String titleTypeDefault() {

			return null;

		}

		public String titleTypeComment() {

			return "";

		}

		public String titleTypePattern() {

			return "dd-MM-yyyy";

		}

		public String titleTypeOriginalDbColumnName() {

			return "titleType";

		}

		public String primaryTitle;

		public String getPrimaryTitle() {
			return this.primaryTitle;
		}

		public Boolean primaryTitleIsNullable() {
			return true;
		}

		public Boolean primaryTitleIsKey() {
			return false;
		}

		public Integer primaryTitleLength() {
			return 49;
		}

		public Integer primaryTitlePrecision() {
			return 0;
		}

		public String primaryTitleDefault() {

			return null;

		}

		public String primaryTitleComment() {

			return "";

		}

		public String primaryTitlePattern() {

			return "dd-MM-yyyy";

		}

		public String primaryTitleOriginalDbColumnName() {

			return "primaryTitle";

		}

		public String originalTitle;

		public String getOriginalTitle() {
			return this.originalTitle;
		}

		public Boolean originalTitleIsNullable() {
			return true;
		}

		public Boolean originalTitleIsKey() {
			return false;
		}

		public Integer originalTitleLength() {
			return 42;
		}

		public Integer originalTitlePrecision() {
			return 0;
		}

		public String originalTitleDefault() {

			return null;

		}

		public String originalTitleComment() {

			return "";

		}

		public String originalTitlePattern() {

			return "dd-MM-yyyy";

		}

		public String originalTitleOriginalDbColumnName() {

			return "originalTitle";

		}

		public Byte isAdult;

		public Byte getIsAdult() {
			return this.isAdult;
		}

		public Boolean isAdultIsNullable() {
			return true;
		}

		public Boolean isAdultIsKey() {
			return false;
		}

		public Integer isAdultLength() {
			return 1;
		}

		public Integer isAdultPrecision() {
			return 0;
		}

		public String isAdultDefault() {

			return null;

		}

		public String isAdultComment() {

			return "";

		}

		public String isAdultPattern() {

			return "dd-MM-yyyy";

		}

		public String isAdultOriginalDbColumnName() {

			return "isAdult";

		}

		public String startYear;

		public String getStartYear() {
			return this.startYear;
		}

		public Boolean startYearIsNullable() {
			return true;
		}

		public Boolean startYearIsKey() {
			return false;
		}

		public Integer startYearLength() {
			return null;
		}

		public Integer startYearPrecision() {
			return 0;
		}

		public String startYearDefault() {

			return null;

		}

		public String startYearComment() {

			return "";

		}

		public String startYearPattern() {

			return "dd-MM-yyyy";

		}

		public String startYearOriginalDbColumnName() {

			return "startYear";

		}

		public String endYear;

		public String getEndYear() {
			return this.endYear;
		}

		public Boolean endYearIsNullable() {
			return true;
		}

		public Boolean endYearIsKey() {
			return false;
		}

		public Integer endYearLength() {
			return 2;
		}

		public Integer endYearPrecision() {
			return 0;
		}

		public String endYearDefault() {

			return null;

		}

		public String endYearComment() {

			return "";

		}

		public String endYearPattern() {

			return "dd-MM-yyyy";

		}

		public String endYearOriginalDbColumnName() {

			return "endYear";

		}

		public String runtimeMinutes;

		public String getRuntimeMinutes() {
			return this.runtimeMinutes;
		}

		public Boolean runtimeMinutesIsNullable() {
			return true;
		}

		public Boolean runtimeMinutesIsKey() {
			return false;
		}

		public Integer runtimeMinutesLength() {
			return null;
		}

		public Integer runtimeMinutesPrecision() {
			return 0;
		}

		public String runtimeMinutesDefault() {

			return null;

		}

		public String runtimeMinutesComment() {

			return "";

		}

		public String runtimeMinutesPattern() {

			return "dd-MM-yyyy";

		}

		public String runtimeMinutesOriginalDbColumnName() {

			return "runtimeMinutes";

		}

		public String genres;

		public String getGenres() {
			return this.genres;
		}

		public Boolean genresIsNullable() {
			return true;
		}

		public Boolean genresIsKey() {
			return false;
		}

		public Integer genresLength() {
			return 24;
		}

		public Integer genresPrecision() {
			return 0;
		}

		public String genresDefault() {

			return null;

		}

		public String genresComment() {

			return "";

		}

		public String genresPattern() {

			return "dd-MM-yyyy";

		}

		public String genresOriginalDbColumnName() {

			return "genres";

		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_GROUP14FINAL_scd_title_basics.length) {
					if (length < 1024 && commonByteArray_GROUP14FINAL_scd_title_basics.length == 0) {
						commonByteArray_GROUP14FINAL_scd_title_basics = new byte[1024];
					} else {
						commonByteArray_GROUP14FINAL_scd_title_basics = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_GROUP14FINAL_scd_title_basics, 0, length);
				strReturn = new String(commonByteArray_GROUP14FINAL_scd_title_basics, 0, length, utf8Charset);
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
				if (length > commonByteArray_GROUP14FINAL_scd_title_basics.length) {
					if (length < 1024 && commonByteArray_GROUP14FINAL_scd_title_basics.length == 0) {
						commonByteArray_GROUP14FINAL_scd_title_basics = new byte[1024];
					} else {
						commonByteArray_GROUP14FINAL_scd_title_basics = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_GROUP14FINAL_scd_title_basics, 0, length);
				strReturn = new String(commonByteArray_GROUP14FINAL_scd_title_basics, 0, length, utf8Charset);
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

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_GROUP14FINAL_scd_title_basics) {

				try {

					int length = 0;

					this.tconst = readString(dis);

					this.titleType = readString(dis);

					this.primaryTitle = readString(dis);

					this.originalTitle = readString(dis);

					length = dis.readByte();
					if (length == -1) {
						this.isAdult = null;
					} else {
						this.isAdult = dis.readByte();
					}

					this.startYear = readString(dis);

					this.endYear = readString(dis);

					this.runtimeMinutes = readString(dis);

					this.genres = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_GROUP14FINAL_scd_title_basics) {

				try {

					int length = 0;

					this.tconst = readString(dis);

					this.titleType = readString(dis);

					this.primaryTitle = readString(dis);

					this.originalTitle = readString(dis);

					length = dis.readByte();
					if (length == -1) {
						this.isAdult = null;
					} else {
						this.isAdult = dis.readByte();
					}

					this.startYear = readString(dis);

					this.endYear = readString(dis);

					this.runtimeMinutes = readString(dis);

					this.genres = readString(dis);

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

				writeString(this.titleType, dos);

				// String

				writeString(this.primaryTitle, dos);

				// String

				writeString(this.originalTitle, dos);

				// Byte

				if (this.isAdult == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeByte(this.isAdult);
				}

				// String

				writeString(this.startYear, dos);

				// String

				writeString(this.endYear, dos);

				// String

				writeString(this.runtimeMinutes, dos);

				// String

				writeString(this.genres, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.tconst, dos);

				// String

				writeString(this.titleType, dos);

				// String

				writeString(this.primaryTitle, dos);

				// String

				writeString(this.originalTitle, dos);

				// Byte

				if (this.isAdult == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeByte(this.isAdult);
				}

				// String

				writeString(this.startYear, dos);

				// String

				writeString(this.endYear, dos);

				// String

				writeString(this.runtimeMinutes, dos);

				// String

				writeString(this.genres, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("tconst=" + tconst);
			sb.append(",titleType=" + titleType);
			sb.append(",primaryTitle=" + primaryTitle);
			sb.append(",originalTitle=" + originalTitle);
			sb.append(",isAdult=" + String.valueOf(isAdult));
			sb.append(",startYear=" + startYear);
			sb.append(",endYear=" + endYear);
			sb.append(",runtimeMinutes=" + runtimeMinutes);
			sb.append(",genres=" + genres);
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

			if (titleType == null) {
				sb.append("<null>");
			} else {
				sb.append(titleType);
			}

			sb.append("|");

			if (primaryTitle == null) {
				sb.append("<null>");
			} else {
				sb.append(primaryTitle);
			}

			sb.append("|");

			if (originalTitle == null) {
				sb.append("<null>");
			} else {
				sb.append(originalTitle);
			}

			sb.append("|");

			if (isAdult == null) {
				sb.append("<null>");
			} else {
				sb.append(isAdult);
			}

			sb.append("|");

			if (startYear == null) {
				sb.append("<null>");
			} else {
				sb.append(startYear);
			}

			sb.append("|");

			if (endYear == null) {
				sb.append("<null>");
			} else {
				sb.append(endYear);
			}

			sb.append("|");

			if (runtimeMinutes == null) {
				sb.append("<null>");
			} else {
				sb.append(runtimeMinutes);
			}

			sb.append("|");

			if (genres == null) {
				sb.append("<null>");
			} else {
				sb.append(genres);
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

	public void tFileList_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tFileList_1_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		mdcInfo.forEach(org.slf4j.MDC::put);
		org.slf4j.MDC.put("_subJobName", "tFileList_1");
		org.slf4j.MDC.put("_subJobPid", "Loa6JA_" + subJobPidCounter.getAndIncrement());

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
				opStruct op = new opStruct();

				/**
				 * [tFileList_1 begin ] start
				 */

				int NB_ITERATE_tFileInputJSON_1 = 0; // for statistics

				ok_Hash.put("tFileList_1", false);
				start_Hash.put("tFileList_1", System.currentTimeMillis());

				currentComponent = "tFileList_1";

				int tos_count_tFileList_1 = 0;

				if (log.isDebugEnabled())
					log.debug("tFileList_1 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tFileList_1 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tFileList_1 = new StringBuilder();
							log4jParamters_tFileList_1.append("Parameters:");
							log4jParamters_tFileList_1.append("DIRECTORY" + " = " + "context.str_title_basics");
							log4jParamters_tFileList_1.append(" | ");
							log4jParamters_tFileList_1.append("LIST_MODE" + " = " + "FILES");
							log4jParamters_tFileList_1.append(" | ");
							log4jParamters_tFileList_1.append("INCLUDSUBDIR" + " = " + "false");
							log4jParamters_tFileList_1.append(" | ");
							log4jParamters_tFileList_1.append("CASE_SENSITIVE" + " = " + "YES");
							log4jParamters_tFileList_1.append(" | ");
							log4jParamters_tFileList_1.append("ERROR" + " = " + "false");
							log4jParamters_tFileList_1.append(" | ");
							log4jParamters_tFileList_1.append("GLOBEXPRESSIONS" + " = " + "true");
							log4jParamters_tFileList_1.append(" | ");
							log4jParamters_tFileList_1.append("FILES" + " = " + "[{FILEMASK=" + ("\".json\"") + "}]");
							log4jParamters_tFileList_1.append(" | ");
							log4jParamters_tFileList_1.append("ORDER_BY_NOTHING" + " = " + "true");
							log4jParamters_tFileList_1.append(" | ");
							log4jParamters_tFileList_1.append("ORDER_BY_FILENAME" + " = " + "false");
							log4jParamters_tFileList_1.append(" | ");
							log4jParamters_tFileList_1.append("ORDER_BY_FILESIZE" + " = " + "false");
							log4jParamters_tFileList_1.append(" | ");
							log4jParamters_tFileList_1.append("ORDER_BY_MODIFIEDDATE" + " = " + "false");
							log4jParamters_tFileList_1.append(" | ");
							log4jParamters_tFileList_1.append("ORDER_ACTION_ASC" + " = " + "true");
							log4jParamters_tFileList_1.append(" | ");
							log4jParamters_tFileList_1.append("ORDER_ACTION_DESC" + " = " + "false");
							log4jParamters_tFileList_1.append(" | ");
							log4jParamters_tFileList_1.append("IFEXCLUDE" + " = " + "false");
							log4jParamters_tFileList_1.append(" | ");
							log4jParamters_tFileList_1.append("FORMAT_FILEPATH_TO_SLASH" + " = " + "false");
							log4jParamters_tFileList_1.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tFileList_1 - " + (log4jParamters_tFileList_1));
						}
					}
					new BytesLimit65535_tFileList_1().limitLog4jByte();
				}
				if (enableLogStash) {
					talendJobLog.addCM("tFileList_1", "tFileList_1", "tFileList");
					talendJobLogProcess(globalMap);
				}

				final StringBuffer log4jSb_tFileList_1 = new StringBuffer();

				String directory_tFileList_1 = context.str_title_basics;
				final java.util.List<String> maskList_tFileList_1 = new java.util.ArrayList<String>();
				final java.util.List<java.util.regex.Pattern> patternList_tFileList_1 = new java.util.ArrayList<java.util.regex.Pattern>();
				maskList_tFileList_1.add(".json");
				for (final String filemask_tFileList_1 : maskList_tFileList_1) {
					String filemask_compile_tFileList_1 = filemask_tFileList_1;

					filemask_compile_tFileList_1 = org.apache.oro.text.GlobCompiler.globToPerl5(
							filemask_tFileList_1.toCharArray(), org.apache.oro.text.GlobCompiler.DEFAULT_MASK);

					java.util.regex.Pattern fileNamePattern_tFileList_1 = java.util.regex.Pattern
							.compile(filemask_compile_tFileList_1);
					patternList_tFileList_1.add(fileNamePattern_tFileList_1);
				}
				int NB_FILEtFileList_1 = 0;

				final boolean case_sensitive_tFileList_1 = true;

				log.info("tFileList_1 - Starting to search for matching entries.");

				final java.util.List<java.io.File> list_tFileList_1 = new java.util.ArrayList<java.io.File>();
				final java.util.Set<String> filePath_tFileList_1 = new java.util.HashSet<String>();
				java.io.File file_tFileList_1 = new java.io.File(directory_tFileList_1);

				file_tFileList_1.listFiles(new java.io.FilenameFilter() {
					public boolean accept(java.io.File dir, String name) {
						java.io.File file = new java.io.File(dir, name);
						if (!file.isDirectory()) {

							String fileName_tFileList_1 = file.getName();
							for (final java.util.regex.Pattern fileNamePattern_tFileList_1 : patternList_tFileList_1) {
								if (fileNamePattern_tFileList_1.matcher(fileName_tFileList_1).matches()) {
									if (!filePath_tFileList_1.contains(file.getAbsolutePath())) {
										list_tFileList_1.add(file);
										filePath_tFileList_1.add(file.getAbsolutePath());
									}
								}
							}
						}
						return true;
					}
				});
				java.util.Collections.sort(list_tFileList_1);

				log.info("tFileList_1 - Start to list files.");

				for (int i_tFileList_1 = 0; i_tFileList_1 < list_tFileList_1.size(); i_tFileList_1++) {
					java.io.File files_tFileList_1 = list_tFileList_1.get(i_tFileList_1);
					String fileName_tFileList_1 = files_tFileList_1.getName();

					String currentFileName_tFileList_1 = files_tFileList_1.getName();
					String currentFilePath_tFileList_1 = files_tFileList_1.getAbsolutePath();
					String currentFileDirectory_tFileList_1 = files_tFileList_1.getParent();
					String currentFileExtension_tFileList_1 = null;

					if (files_tFileList_1.getName().contains(".") && files_tFileList_1.isFile()) {
						currentFileExtension_tFileList_1 = files_tFileList_1.getName()
								.substring(files_tFileList_1.getName().lastIndexOf(".") + 1);
					} else {
						currentFileExtension_tFileList_1 = "";
					}

					NB_FILEtFileList_1++;
					globalMap.put("tFileList_1_CURRENT_FILE", currentFileName_tFileList_1);
					globalMap.put("tFileList_1_CURRENT_FILEPATH", currentFilePath_tFileList_1);
					globalMap.put("tFileList_1_CURRENT_FILEDIRECTORY", currentFileDirectory_tFileList_1);
					globalMap.put("tFileList_1_CURRENT_FILEEXTENSION", currentFileExtension_tFileList_1);
					globalMap.put("tFileList_1_NB_FILE", NB_FILEtFileList_1);

					log.info("tFileList_1 - Current file or directory path : " + currentFilePath_tFileList_1);

					/**
					 * [tFileList_1 begin ] stop
					 */

					/**
					 * [tFileList_1 main ] start
					 */

					currentComponent = "tFileList_1";

					tos_count_tFileList_1++;

					/**
					 * [tFileList_1 main ] stop
					 */

					/**
					 * [tFileList_1 process_data_begin ] start
					 */

					currentComponent = "tFileList_1";

					/**
					 * [tFileList_1 process_data_begin ] stop
					 */
					NB_ITERATE_tFileInputJSON_1++;

					if (execStat) {
						runStat.updateStatOnConnection("row1", 3, 0);
					}

					if (execStat) {
						runStat.updateStatOnConnection("op", 3, 0);
					}

					if (execStat) {
						runStat.updateStatOnConnection("iterate1", 1, "exec" + NB_ITERATE_tFileInputJSON_1);
						// Thread.sleep(1000);
					}

					/**
					 * [tDBSCD_1 begin ] start
					 */

					ok_Hash.put("tDBSCD_1", false);
					start_Hash.put("tDBSCD_1", System.currentTimeMillis());

					currentComponent = "tDBSCD_1";

					cLabel = "\"scd_title_basics\"";

					runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, 0, 0, "op");

					int tos_count_tDBSCD_1 = 0;

					if (enableLogStash) {
						talendJobLog.addCM("tDBSCD_1", "\"scd_title_basics\"", "tMysqlSCD");
						talendJobLogProcess(globalMap);
					}

					class CompareUtil_tDBSCD_1 {

						boolean scdEquals(java.util.Date d1, java.util.Date d2) {
							if (d1 != null && d2 != null) {
								return java.lang.Math.abs(d1.getTime() - d2.getTime()) <= 999;
							}
							return d1 == d2;
						}

					}

					CompareUtil_tDBSCD_1 cu_tDBSCD_1 = new CompareUtil_tDBSCD_1();

					class SCDSK_tDBSCD_1 {
						private int hashCode;
						public boolean hashCodeDirty = true;
						String tconst;

						public boolean equals(Object obj) {
							if (this == obj)
								return true;
							if (obj == null)
								return false;
							if (getClass() != obj.getClass())
								return false;
							final SCDSK_tDBSCD_1 other = (SCDSK_tDBSCD_1) obj;
							if (this.tconst == null) {
								if (other.tconst != null)
									return false;
							} else if (!this.tconst.equals(other.tconst))
								return false;

							return true;
						}

						public int hashCode() {
							if (hashCodeDirty) {
								int prime = 31;
								hashCode = prime * hashCode + (tconst == null ? 0 : tconst.hashCode());
								hashCodeDirty = false;
							}
							return hashCode;
						}
					}

					class SCDStruct_tDBSCD_1 {
						private java.util.Date DI_Created_Date;
						private String DI_JobId;
						private String endYear;
						private String genres;
						private String originalTitle;
						private Byte isAdult;
						private String runtimeMinutes;
						private String titleType;
						private String startYear;
						private String primaryTitle;
						private int scd_version;
					}

					int nb_line_update_tDBSCD_1 = 0;
					int nb_line_inserted_tDBSCD_1 = 0;
					int nb_line_rejected_tDBSCD_1 = 0;
					String tableName_tDBSCD_1 = "scd_title_basics";
					java.lang.Class.forName("com.mysql.cj.jdbc.Driver");

					String properties_tDBSCD_1 = context.imdb_AdditionalParams;
					if (properties_tDBSCD_1 == null || properties_tDBSCD_1.trim().length() == 0) {
						properties_tDBSCD_1 = "";
					}
					String url_tDBSCD_1 = "jdbc:mysql://" + context.imdb_Server + ":" + context.imdb_Port + "/"
							+ context.imdb_Database + "?" + properties_tDBSCD_1;

					final String decryptedPassword_tDBSCD_1 = context.imdb_Password;

					java.sql.Connection connection_tDBSCD_1 = java.sql.DriverManager.getConnection(url_tDBSCD_1,
							context.imdb_Login, decryptedPassword_tDBSCD_1);

					java.util.Calendar calendar_tDBSCD_1 = java.util.Calendar.getInstance();
					java.util.Calendar calendarYear0_tDBSCD_1 = java.util.Calendar.getInstance();

					calendar_tDBSCD_1.set(1, 0, 1, 0, 0, 0);
					calendarYear0_tDBSCD_1.set(0, 0, 0, 0, 0, 0);

					final java.util.Date dateYear0_tDBSCD_1 = calendarYear0_tDBSCD_1.getTime();
					final long year1_tDBSCD_1 = calendar_tDBSCD_1.getTime().getTime();

					calendar_tDBSCD_1.set(10000, 0, 1, 0, 0, 0);
					final long year10000_tDBSCD_1 = calendar_tDBSCD_1.getTime().getTime();
					long date_tDBSCD_1 = 0;
					String dateStr_tDBSCD_1 = null;
					String tmpValue_tDBSCD_1 = null;
					String search_tDBSCD_1 = "SELECT `tconst`, `DI_Created_Date`, `DI_JobId`, `endYear`, `genres`, `originalTitle`, `isAdult`, `runtimeMinutes`, `titleType`, `startYear`, `primaryTitle`, `scd_version` FROM `"
							+ tableName_tDBSCD_1 + "` WHERE YEAR(`scd_end`) = " + 2050 + "";
					java.sql.Statement statement_tDBSCD_1 = connection_tDBSCD_1.createStatement();
					java.sql.ResultSet resultSet_tDBSCD_1 = statement_tDBSCD_1.executeQuery(search_tDBSCD_1);
					java.util.Map<SCDSK_tDBSCD_1, SCDStruct_tDBSCD_1> cache_tDBSCD_1 = new java.util.HashMap<SCDSK_tDBSCD_1, SCDStruct_tDBSCD_1>();
					while (resultSet_tDBSCD_1.next()) {
						SCDSK_tDBSCD_1 sk_tDBSCD_1 = new SCDSK_tDBSCD_1();
						SCDStruct_tDBSCD_1 row_tDBSCD_1 = new SCDStruct_tDBSCD_1();
						if (resultSet_tDBSCD_1.getObject(1) != null) {
							sk_tDBSCD_1.tconst = resultSet_tDBSCD_1.getString(1);
						}
						dateStr_tDBSCD_1 = resultSet_tDBSCD_1.getString(2);
						if (dateStr_tDBSCD_1 != null) {
							if (!("0000-00-00").equals(dateStr_tDBSCD_1)
									&& !("0000-00-00 00:00:00").equals(dateStr_tDBSCD_1)) {
								row_tDBSCD_1.DI_Created_Date = new java.util.Date(
										resultSet_tDBSCD_1.getTimestamp(2).getTime());
							} else {
								row_tDBSCD_1.DI_Created_Date = (java.util.Date) dateYear0_tDBSCD_1.clone();
							}
						} else {
							row_tDBSCD_1.DI_Created_Date = null;
						}
						if (resultSet_tDBSCD_1.getObject(3) != null) {
							row_tDBSCD_1.DI_JobId = resultSet_tDBSCD_1.getString(3);
						}
						if (resultSet_tDBSCD_1.getObject(4) != null) {
							row_tDBSCD_1.endYear = resultSet_tDBSCD_1.getString(4);
						}
						if (resultSet_tDBSCD_1.getObject(5) != null) {
							row_tDBSCD_1.genres = resultSet_tDBSCD_1.getString(5);
						}
						if (resultSet_tDBSCD_1.getObject(6) != null) {
							row_tDBSCD_1.originalTitle = resultSet_tDBSCD_1.getString(6);
						}
						if (resultSet_tDBSCD_1.getObject(7) != null) {
							row_tDBSCD_1.isAdult = resultSet_tDBSCD_1.getByte(7);
						}
						if (resultSet_tDBSCD_1.getObject(8) != null) {
							row_tDBSCD_1.runtimeMinutes = resultSet_tDBSCD_1.getString(8);
						}
						if (resultSet_tDBSCD_1.getObject(9) != null) {
							row_tDBSCD_1.titleType = resultSet_tDBSCD_1.getString(9);
						}
						if (resultSet_tDBSCD_1.getObject(10) != null) {
							row_tDBSCD_1.startYear = resultSet_tDBSCD_1.getString(10);
						}
						if (resultSet_tDBSCD_1.getObject(11) != null) {
							row_tDBSCD_1.primaryTitle = resultSet_tDBSCD_1.getString(11);
						}
						if (resultSet_tDBSCD_1.getObject(12) != null) {
							row_tDBSCD_1.scd_version = resultSet_tDBSCD_1.getInt(12);
						}
						cache_tDBSCD_1.put(sk_tDBSCD_1, row_tDBSCD_1);
					}
					resultSet_tDBSCD_1.close();
					statement_tDBSCD_1.close();
					String insertionSQL_tDBSCD_1 = "INSERT INTO `" + tableName_tDBSCD_1
							+ "`(`tconst`, `DI_Created_Date`, `DI_JobId`, `endYear`, `genres`, `originalTitle`, `isAdult`, `runtimeMinutes`, `titleType`, `startYear`, `primaryTitle`, `scd_active`, `scd_version`, `scd_start`, `scd_end`) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, b'1', ?, ?, ?)";
					java.sql.PreparedStatement insertionStatement_tDBSCD_1 = connection_tDBSCD_1
							.prepareStatement(insertionSQL_tDBSCD_1);
					String endDateTimeDetail_tDBSCD_1 = "12:00:00";
					String datePattern_tDBSCD_1 = "yyyy-MM-dd";
					if (endDateTimeDetail_tDBSCD_1.length() > 0) {
						endDateTimeDetail_tDBSCD_1 = " " + endDateTimeDetail_tDBSCD_1;
						datePattern_tDBSCD_1 = "yyyy-MM-dd HH:mm:ss";
					}
					insertionStatement_tDBSCD_1.setTimestamp(14,
							new java.sql.Timestamp(new java.text.SimpleDateFormat(datePattern_tDBSCD_1)
									.parse(2050 + "-01-01" + endDateTimeDetail_tDBSCD_1).getTime()));
					String updateSQLForType1_tDBSCD_1 = "UPDATE `" + tableName_tDBSCD_1
							+ "` SET `DI_Created_Date` = ?, `DI_JobId` = ?, `endYear` = ?, `genres` = ?, `originalTitle` = ?, `isAdult` = ?, `runtimeMinutes` = ?, `titleType` = ?, `startYear` = ? WHERE `tconst` = ?";
					java.sql.PreparedStatement updateForType1_tDBSCD_1 = connection_tDBSCD_1
							.prepareStatement(updateSQLForType1_tDBSCD_1);
					String updateSQLForType2_tDBSCD_1 = "UPDATE `" + tableName_tDBSCD_1
							+ "` SET `scd_end` = ?, `scd_active` = b'0' WHERE `tconst` = ? AND YEAR(`scd_end`) = "
							+ 2050 + "";
					java.sql.PreparedStatement updateForType2_tDBSCD_1 = connection_tDBSCD_1
							.prepareStatement(updateSQLForType2_tDBSCD_1);

					SCDSK_tDBSCD_1 lookUpKey_tDBSCD_1 = null;
					SCDStruct_tDBSCD_1 lookUpValue_tDBSCD_1 = null;

					/**
					 * [tDBSCD_1 begin ] stop
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
					int count_op_tMap_1 = 0;

					opStruct op_tmp = new opStruct();
// ###############################

					/**
					 * [tMap_1 begin ] stop
					 */

					/**
					 * [tFileInputJSON_1 begin ] start
					 */

					ok_Hash.put("tFileInputJSON_1", false);
					start_Hash.put("tFileInputJSON_1", System.currentTimeMillis());

					currentComponent = "tFileInputJSON_1";

					cLabel = "title_basics";

					int tos_count_tFileInputJSON_1 = 0;

					if (log.isDebugEnabled())
						log.debug("tFileInputJSON_1 - " + ("Start to work."));
					if (log.isDebugEnabled()) {
						class BytesLimit65535_tFileInputJSON_1 {
							public void limitLog4jByte() throws Exception {
								StringBuilder log4jParamters_tFileInputJSON_1 = new StringBuilder();
								log4jParamters_tFileInputJSON_1.append("Parameters:");
								log4jParamters_tFileInputJSON_1.append("READ_BY" + " = " + "JSONPATH");
								log4jParamters_tFileInputJSON_1.append(" | ");
								log4jParamters_tFileInputJSON_1.append("JSON_PATH_VERSION" + " = " + "2_1_0");
								log4jParamters_tFileInputJSON_1.append(" | ");
								log4jParamters_tFileInputJSON_1.append("USEURL" + " = " + "false");
								log4jParamters_tFileInputJSON_1.append(" | ");
								log4jParamters_tFileInputJSON_1.append("FILENAME" + " = "
										+ "((String)globalMap.get(\"tFileList_1_CURRENT_FILEPATH\"))");
								log4jParamters_tFileInputJSON_1.append(" | ");
								log4jParamters_tFileInputJSON_1.append("JSON_LOOP_QUERY" + " = " + "\"$[*]\"");
								log4jParamters_tFileInputJSON_1.append(" | ");
								log4jParamters_tFileInputJSON_1.append("MAPPING_JSONPATH" + " = " + "[{QUERY="
										+ ("\"tconst\"") + ", SCHEMA_COLUMN=" + ("tconst") + "}, {QUERY="
										+ ("\"titleType\"") + ", SCHEMA_COLUMN=" + ("titleType") + "}, {QUERY="
										+ ("\"primaryTitle\"") + ", SCHEMA_COLUMN=" + ("primaryTitle") + "}, {QUERY="
										+ ("\"originalTitle\"") + ", SCHEMA_COLUMN=" + ("originalTitle") + "}, {QUERY="
										+ ("\"isAdult\"") + ", SCHEMA_COLUMN=" + ("isAdult") + "}, {QUERY="
										+ ("\"startYear\"") + ", SCHEMA_COLUMN=" + ("startYear") + "}, {QUERY="
										+ ("\"endYear\"") + ", SCHEMA_COLUMN=" + ("endYear") + "}, {QUERY="
										+ ("\"runtimeMinutes\"") + ", SCHEMA_COLUMN=" + ("runtimeMinutes")
										+ "}, {QUERY=" + ("\"genres\"") + ", SCHEMA_COLUMN=" + ("genres") + "}]");
								log4jParamters_tFileInputJSON_1.append(" | ");
								log4jParamters_tFileInputJSON_1.append("DIE_ON_ERROR" + " = " + "false");
								log4jParamters_tFileInputJSON_1.append(" | ");
								log4jParamters_tFileInputJSON_1.append("ADVANCED_SEPARATOR" + " = " + "false");
								log4jParamters_tFileInputJSON_1.append(" | ");
								log4jParamters_tFileInputJSON_1.append("USE_LOOP_AS_ROOT" + " = " + "false");
								log4jParamters_tFileInputJSON_1.append(" | ");
								log4jParamters_tFileInputJSON_1.append("ENCODING" + " = " + "\"UTF-8\"");
								log4jParamters_tFileInputJSON_1.append(" | ");
								if (log.isDebugEnabled())
									log.debug("tFileInputJSON_1 - " + (log4jParamters_tFileInputJSON_1));
							}
						}
						new BytesLimit65535_tFileInputJSON_1().limitLog4jByte();
					}
					if (enableLogStash) {
						talendJobLog.addCM("tFileInputJSON_1", "title_basics", "tFileInputJSON");
						talendJobLogProcess(globalMap);
					}

					class JsonPathCache_tFileInputJSON_1 {
						final java.util.Map<String, com.jayway.jsonpath.JsonPath> jsonPathString2compiledJsonPath = new java.util.HashMap<String, com.jayway.jsonpath.JsonPath>();

						public com.jayway.jsonpath.JsonPath getCompiledJsonPath(String jsonPath) {
							if (jsonPathString2compiledJsonPath.containsKey(jsonPath)) {
								return jsonPathString2compiledJsonPath.get(jsonPath);
							} else {
								com.jayway.jsonpath.JsonPath compiledLoopPath = com.jayway.jsonpath.JsonPath
										.compile(jsonPath);
								jsonPathString2compiledJsonPath.put(jsonPath, compiledLoopPath);
								return compiledLoopPath;
							}
						}
					}

					int nb_line_tFileInputJSON_1 = 0;

					JsonPathCache_tFileInputJSON_1 jsonPathCache_tFileInputJSON_1 = new JsonPathCache_tFileInputJSON_1();

					String loopPath_tFileInputJSON_1 = "$[*]";
					java.util.List<Object> resultset_tFileInputJSON_1 = new java.util.ArrayList<Object>();

					java.io.InputStream is_tFileInputJSON_1 = null;
					com.jayway.jsonpath.ParseContext parseContext_tFileInputJSON_1 = com.jayway.jsonpath.JsonPath
							.using(com.jayway.jsonpath.Configuration.defaultConfiguration());
					Object filenameOrStream_tFileInputJSON_1 = null;
					try {
						filenameOrStream_tFileInputJSON_1 = ((String) globalMap.get("tFileList_1_CURRENT_FILEPATH"));
					} catch (java.lang.Exception e_tFileInputJSON_1) {
						globalMap.put("tFileInputJSON_1_ERROR_MESSAGE", e_tFileInputJSON_1.getMessage());

						log.error("tFileInputJSON_1 - " + e_tFileInputJSON_1.getMessage());

						globalMap.put("tFileInputJSON_1_ERROR_MESSAGE", e_tFileInputJSON_1.getMessage());
						System.err.println(e_tFileInputJSON_1.getMessage());
					}

					com.jayway.jsonpath.ReadContext document_tFileInputJSON_1 = null;
					try {
						if (filenameOrStream_tFileInputJSON_1 instanceof java.io.InputStream) {
							is_tFileInputJSON_1 = (java.io.InputStream) filenameOrStream_tFileInputJSON_1;
						} else {

							is_tFileInputJSON_1 = new java.io.FileInputStream(
									(String) filenameOrStream_tFileInputJSON_1);

						}

						document_tFileInputJSON_1 = parseContext_tFileInputJSON_1.parse(is_tFileInputJSON_1, "UTF-8");
						com.jayway.jsonpath.JsonPath compiledLoopPath_tFileInputJSON_1 = jsonPathCache_tFileInputJSON_1
								.getCompiledJsonPath(loopPath_tFileInputJSON_1);
						Object result_tFileInputJSON_1 = document_tFileInputJSON_1
								.read(compiledLoopPath_tFileInputJSON_1, net.minidev.json.JSONObject.class);
						if (result_tFileInputJSON_1 instanceof net.minidev.json.JSONArray) {
							resultset_tFileInputJSON_1 = (net.minidev.json.JSONArray) result_tFileInputJSON_1;
						} else {
							resultset_tFileInputJSON_1.add(result_tFileInputJSON_1);
						}
					} catch (java.lang.Exception e_tFileInputJSON_1) {
						globalMap.put("tFileInputJSON_1_ERROR_MESSAGE", e_tFileInputJSON_1.getMessage());
						log.error("tFileInputJSON_1 - " + e_tFileInputJSON_1.getMessage());

						globalMap.put("tFileInputJSON_1_ERROR_MESSAGE", e_tFileInputJSON_1.getMessage());
						System.err.println(e_tFileInputJSON_1.getMessage());
					} finally {
						if (is_tFileInputJSON_1 != null) {
							is_tFileInputJSON_1.close();
						}
					}

					String jsonPath_tFileInputJSON_1 = null;
					com.jayway.jsonpath.JsonPath compiledJsonPath_tFileInputJSON_1 = null;

					Object value_tFileInputJSON_1 = null;
					log.info("tFileInputJSON_1 - Retrieving records from data.");
					Object root_tFileInputJSON_1 = null;
					for (Object row_tFileInputJSON_1 : resultset_tFileInputJSON_1) {
						nb_line_tFileInputJSON_1++;
						log.debug("tFileInputJSON_1 - Retrieving the record " + (nb_line_tFileInputJSON_1) + ".");

						row1 = null;
						boolean whetherReject_tFileInputJSON_1 = false;
						row1 = new row1Struct();

						try {
							jsonPath_tFileInputJSON_1 = "tconst";
							compiledJsonPath_tFileInputJSON_1 = jsonPathCache_tFileInputJSON_1
									.getCompiledJsonPath(jsonPath_tFileInputJSON_1);

							try {

								if (jsonPath_tFileInputJSON_1.startsWith("$")) {
									if (root_tFileInputJSON_1 == null) {
										root_tFileInputJSON_1 = document_tFileInputJSON_1
												.read(jsonPathCache_tFileInputJSON_1.getCompiledJsonPath("$"));
									}
									value_tFileInputJSON_1 = compiledJsonPath_tFileInputJSON_1
											.read(root_tFileInputJSON_1);
								} else {
									value_tFileInputJSON_1 = compiledJsonPath_tFileInputJSON_1
											.read(row_tFileInputJSON_1);
								}
								row1.tconst = value_tFileInputJSON_1 == null ?

										null : value_tFileInputJSON_1.toString();
							} catch (com.jayway.jsonpath.PathNotFoundException e_tFileInputJSON_1) {
								globalMap.put("tFileInputJSON_1_ERROR_MESSAGE", e_tFileInputJSON_1.getMessage());
								row1.tconst =

										null;
							}
							jsonPath_tFileInputJSON_1 = "titleType";
							compiledJsonPath_tFileInputJSON_1 = jsonPathCache_tFileInputJSON_1
									.getCompiledJsonPath(jsonPath_tFileInputJSON_1);

							try {

								if (jsonPath_tFileInputJSON_1.startsWith("$")) {
									if (root_tFileInputJSON_1 == null) {
										root_tFileInputJSON_1 = document_tFileInputJSON_1
												.read(jsonPathCache_tFileInputJSON_1.getCompiledJsonPath("$"));
									}
									value_tFileInputJSON_1 = compiledJsonPath_tFileInputJSON_1
											.read(root_tFileInputJSON_1);
								} else {
									value_tFileInputJSON_1 = compiledJsonPath_tFileInputJSON_1
											.read(row_tFileInputJSON_1);
								}
								row1.titleType = value_tFileInputJSON_1 == null ?

										null : value_tFileInputJSON_1.toString();
							} catch (com.jayway.jsonpath.PathNotFoundException e_tFileInputJSON_1) {
								globalMap.put("tFileInputJSON_1_ERROR_MESSAGE", e_tFileInputJSON_1.getMessage());
								row1.titleType =

										null;
							}
							jsonPath_tFileInputJSON_1 = "primaryTitle";
							compiledJsonPath_tFileInputJSON_1 = jsonPathCache_tFileInputJSON_1
									.getCompiledJsonPath(jsonPath_tFileInputJSON_1);

							try {

								if (jsonPath_tFileInputJSON_1.startsWith("$")) {
									if (root_tFileInputJSON_1 == null) {
										root_tFileInputJSON_1 = document_tFileInputJSON_1
												.read(jsonPathCache_tFileInputJSON_1.getCompiledJsonPath("$"));
									}
									value_tFileInputJSON_1 = compiledJsonPath_tFileInputJSON_1
											.read(root_tFileInputJSON_1);
								} else {
									value_tFileInputJSON_1 = compiledJsonPath_tFileInputJSON_1
											.read(row_tFileInputJSON_1);
								}
								row1.primaryTitle = value_tFileInputJSON_1 == null ?

										null : value_tFileInputJSON_1.toString();
							} catch (com.jayway.jsonpath.PathNotFoundException e_tFileInputJSON_1) {
								globalMap.put("tFileInputJSON_1_ERROR_MESSAGE", e_tFileInputJSON_1.getMessage());
								row1.primaryTitle =

										null;
							}
							jsonPath_tFileInputJSON_1 = "originalTitle";
							compiledJsonPath_tFileInputJSON_1 = jsonPathCache_tFileInputJSON_1
									.getCompiledJsonPath(jsonPath_tFileInputJSON_1);

							try {

								if (jsonPath_tFileInputJSON_1.startsWith("$")) {
									if (root_tFileInputJSON_1 == null) {
										root_tFileInputJSON_1 = document_tFileInputJSON_1
												.read(jsonPathCache_tFileInputJSON_1.getCompiledJsonPath("$"));
									}
									value_tFileInputJSON_1 = compiledJsonPath_tFileInputJSON_1
											.read(root_tFileInputJSON_1);
								} else {
									value_tFileInputJSON_1 = compiledJsonPath_tFileInputJSON_1
											.read(row_tFileInputJSON_1);
								}
								row1.originalTitle = value_tFileInputJSON_1 == null ?

										null : value_tFileInputJSON_1.toString();
							} catch (com.jayway.jsonpath.PathNotFoundException e_tFileInputJSON_1) {
								globalMap.put("tFileInputJSON_1_ERROR_MESSAGE", e_tFileInputJSON_1.getMessage());
								row1.originalTitle =

										null;
							}
							jsonPath_tFileInputJSON_1 = "isAdult";
							compiledJsonPath_tFileInputJSON_1 = jsonPathCache_tFileInputJSON_1
									.getCompiledJsonPath(jsonPath_tFileInputJSON_1);

							try {

								if (jsonPath_tFileInputJSON_1.startsWith("$")) {
									if (root_tFileInputJSON_1 == null) {
										root_tFileInputJSON_1 = document_tFileInputJSON_1
												.read(jsonPathCache_tFileInputJSON_1.getCompiledJsonPath("$"));
									}
									value_tFileInputJSON_1 = compiledJsonPath_tFileInputJSON_1
											.read(root_tFileInputJSON_1);
								} else {
									value_tFileInputJSON_1 = compiledJsonPath_tFileInputJSON_1
											.read(row_tFileInputJSON_1);
								}
								if (value_tFileInputJSON_1 != null && !value_tFileInputJSON_1.toString().isEmpty()) {
									row1.isAdult = ParserUtils.parseTo_Byte(value_tFileInputJSON_1.toString());
								} else {
									row1.isAdult =

											null;
								}
							} catch (com.jayway.jsonpath.PathNotFoundException e_tFileInputJSON_1) {
								globalMap.put("tFileInputJSON_1_ERROR_MESSAGE", e_tFileInputJSON_1.getMessage());
								row1.isAdult =

										null;
							}
							jsonPath_tFileInputJSON_1 = "startYear";
							compiledJsonPath_tFileInputJSON_1 = jsonPathCache_tFileInputJSON_1
									.getCompiledJsonPath(jsonPath_tFileInputJSON_1);

							try {

								if (jsonPath_tFileInputJSON_1.startsWith("$")) {
									if (root_tFileInputJSON_1 == null) {
										root_tFileInputJSON_1 = document_tFileInputJSON_1
												.read(jsonPathCache_tFileInputJSON_1.getCompiledJsonPath("$"));
									}
									value_tFileInputJSON_1 = compiledJsonPath_tFileInputJSON_1
											.read(root_tFileInputJSON_1);
								} else {
									value_tFileInputJSON_1 = compiledJsonPath_tFileInputJSON_1
											.read(row_tFileInputJSON_1);
								}
								row1.startYear = value_tFileInputJSON_1 == null ?

										null : value_tFileInputJSON_1.toString();
							} catch (com.jayway.jsonpath.PathNotFoundException e_tFileInputJSON_1) {
								globalMap.put("tFileInputJSON_1_ERROR_MESSAGE", e_tFileInputJSON_1.getMessage());
								row1.startYear =

										null;
							}
							jsonPath_tFileInputJSON_1 = "endYear";
							compiledJsonPath_tFileInputJSON_1 = jsonPathCache_tFileInputJSON_1
									.getCompiledJsonPath(jsonPath_tFileInputJSON_1);

							try {

								if (jsonPath_tFileInputJSON_1.startsWith("$")) {
									if (root_tFileInputJSON_1 == null) {
										root_tFileInputJSON_1 = document_tFileInputJSON_1
												.read(jsonPathCache_tFileInputJSON_1.getCompiledJsonPath("$"));
									}
									value_tFileInputJSON_1 = compiledJsonPath_tFileInputJSON_1
											.read(root_tFileInputJSON_1);
								} else {
									value_tFileInputJSON_1 = compiledJsonPath_tFileInputJSON_1
											.read(row_tFileInputJSON_1);
								}
								row1.endYear = value_tFileInputJSON_1 == null ?

										null : value_tFileInputJSON_1.toString();
							} catch (com.jayway.jsonpath.PathNotFoundException e_tFileInputJSON_1) {
								globalMap.put("tFileInputJSON_1_ERROR_MESSAGE", e_tFileInputJSON_1.getMessage());
								row1.endYear =

										null;
							}
							jsonPath_tFileInputJSON_1 = "runtimeMinutes";
							compiledJsonPath_tFileInputJSON_1 = jsonPathCache_tFileInputJSON_1
									.getCompiledJsonPath(jsonPath_tFileInputJSON_1);

							try {

								if (jsonPath_tFileInputJSON_1.startsWith("$")) {
									if (root_tFileInputJSON_1 == null) {
										root_tFileInputJSON_1 = document_tFileInputJSON_1
												.read(jsonPathCache_tFileInputJSON_1.getCompiledJsonPath("$"));
									}
									value_tFileInputJSON_1 = compiledJsonPath_tFileInputJSON_1
											.read(root_tFileInputJSON_1);
								} else {
									value_tFileInputJSON_1 = compiledJsonPath_tFileInputJSON_1
											.read(row_tFileInputJSON_1);
								}
								row1.runtimeMinutes = value_tFileInputJSON_1 == null ?

										null : value_tFileInputJSON_1.toString();
							} catch (com.jayway.jsonpath.PathNotFoundException e_tFileInputJSON_1) {
								globalMap.put("tFileInputJSON_1_ERROR_MESSAGE", e_tFileInputJSON_1.getMessage());
								row1.runtimeMinutes =

										null;
							}
							jsonPath_tFileInputJSON_1 = "genres";
							compiledJsonPath_tFileInputJSON_1 = jsonPathCache_tFileInputJSON_1
									.getCompiledJsonPath(jsonPath_tFileInputJSON_1);

							try {

								if (jsonPath_tFileInputJSON_1.startsWith("$")) {
									if (root_tFileInputJSON_1 == null) {
										root_tFileInputJSON_1 = document_tFileInputJSON_1
												.read(jsonPathCache_tFileInputJSON_1.getCompiledJsonPath("$"));
									}
									value_tFileInputJSON_1 = compiledJsonPath_tFileInputJSON_1
											.read(root_tFileInputJSON_1);
								} else {
									value_tFileInputJSON_1 = compiledJsonPath_tFileInputJSON_1
											.read(row_tFileInputJSON_1);
								}
								row1.genres = value_tFileInputJSON_1 == null ?

										null : value_tFileInputJSON_1.toString();
							} catch (com.jayway.jsonpath.PathNotFoundException e_tFileInputJSON_1) {
								globalMap.put("tFileInputJSON_1_ERROR_MESSAGE", e_tFileInputJSON_1.getMessage());
								row1.genres =

										null;
							}
						} catch (java.lang.Exception e_tFileInputJSON_1) {
							globalMap.put("tFileInputJSON_1_ERROR_MESSAGE", e_tFileInputJSON_1.getMessage());
							whetherReject_tFileInputJSON_1 = true;
							log.error("tFileInputJSON_1 - " + e_tFileInputJSON_1.getMessage());

							System.err.println(e_tFileInputJSON_1.getMessage());
							row1 = null;
							globalMap.put("tFileInputJSON_1_ERROR_MESSAGE", e_tFileInputJSON_1.getMessage());
						}
//}

						/**
						 * [tFileInputJSON_1 begin ] stop
						 */

						/**
						 * [tFileInputJSON_1 main ] start
						 */

						currentComponent = "tFileInputJSON_1";

						cLabel = "title_basics";

						tos_count_tFileInputJSON_1++;

						/**
						 * [tFileInputJSON_1 main ] stop
						 */

						/**
						 * [tFileInputJSON_1 process_data_begin ] start
						 */

						currentComponent = "tFileInputJSON_1";

						cLabel = "title_basics";

						/**
						 * [tFileInputJSON_1 process_data_begin ] stop
						 */
// Start of branch "row1"
						if (row1 != null) {

							/**
							 * [tMap_1 main ] start
							 */

							currentComponent = "tMap_1";

							if (runStat.update(execStat, enableLogStash, iterateId, 1, 1

									, "row1", "tFileInputJSON_1", "title_basics", "tFileInputJSON", "tMap_1", "tMap_1",
									"tMap"

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

								op = null;

// # Output table : 'op'
								count_op_tMap_1++;

								op_tmp.tconst = row1.tconst;
								op_tmp.titleType = row1.titleType;
								op_tmp.primaryTitle = row1.primaryTitle;
								op_tmp.originalTitle = row1.originalTitle;
								op_tmp.isAdult = row1.isAdult;
								op_tmp.startYear = row1.startYear;
								op_tmp.endYear = row1.endYear;
								op_tmp.runtimeMinutes = row1.runtimeMinutes;
								op_tmp.genres = row1.genres;
								op_tmp.DI_Created_Date = TalendDate.getCurrentDate();
								op_tmp.DI_JobId = pid;
								op = op_tmp;
								log.debug("tMap_1 - Outputting the record " + count_op_tMap_1
										+ " of the output table 'op'.");

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
// Start of branch "op"
							if (op != null) {

								/**
								 * [tDBSCD_1 main ] start
								 */

								currentComponent = "tDBSCD_1";

								cLabel = "\"scd_title_basics\"";

								if (runStat.update(execStat, enableLogStash, iterateId, 1, 1

										, "op", "tMap_1", "tMap_1", "tMap", "tDBSCD_1", "\"scd_title_basics\"",
										"tMysqlSCD"

								)) {
									talendJobLogProcess(globalMap);
								}

								if (log.isTraceEnabled()) {
									log.trace("op - " + (op == null ? "" : op.toLogString()));
								}

								try {
									lookUpKey_tDBSCD_1 = new SCDSK_tDBSCD_1();
									lookUpKey_tDBSCD_1.tconst = op.tconst;
									lookUpKey_tDBSCD_1.hashCodeDirty = true;
									lookUpValue_tDBSCD_1 = cache_tDBSCD_1.get(lookUpKey_tDBSCD_1);
									if (lookUpValue_tDBSCD_1 == null) {
										lookUpValue_tDBSCD_1 = new SCDStruct_tDBSCD_1();
										lookUpValue_tDBSCD_1.scd_version = 1;

										if (op.tconst == null) {
											insertionStatement_tDBSCD_1.setNull(1, java.sql.Types.VARCHAR);
										} else {
											insertionStatement_tDBSCD_1.setString(1, op.tconst);
										}

										if (op.DI_Created_Date == null) {
											insertionStatement_tDBSCD_1.setNull(2, java.sql.Types.DATE);
										} else {
											if (op.DI_Created_Date != null) {
												date_tDBSCD_1 = op.DI_Created_Date.getTime();
												if (date_tDBSCD_1 < year1_tDBSCD_1
														|| date_tDBSCD_1 >= year10000_tDBSCD_1) {
													insertionStatement_tDBSCD_1.setString(2, "0000-00-00 00:00:00");
												} else {
													insertionStatement_tDBSCD_1.setTimestamp(2,
															new java.sql.Timestamp(date_tDBSCD_1));
												}
											} else {
												insertionStatement_tDBSCD_1.setNull(2, java.sql.Types.DATE);
											}
										}

										if (op.DI_JobId == null) {
											insertionStatement_tDBSCD_1.setNull(3, java.sql.Types.VARCHAR);
										} else {
											insertionStatement_tDBSCD_1.setString(3, op.DI_JobId);
										}

										if (op.endYear == null) {
											insertionStatement_tDBSCD_1.setNull(4, java.sql.Types.VARCHAR);
										} else {
											insertionStatement_tDBSCD_1.setString(4, op.endYear);
										}

										if (op.genres == null) {
											insertionStatement_tDBSCD_1.setNull(5, java.sql.Types.VARCHAR);
										} else {
											insertionStatement_tDBSCD_1.setString(5, op.genres);
										}

										if (op.originalTitle == null) {
											insertionStatement_tDBSCD_1.setNull(6, java.sql.Types.VARCHAR);
										} else {
											insertionStatement_tDBSCD_1.setString(6, op.originalTitle);
										}

										if (op.isAdult == null) {
											insertionStatement_tDBSCD_1.setNull(7, java.sql.Types.INTEGER);
										} else {
											insertionStatement_tDBSCD_1.setByte(7, op.isAdult);
										}

										if (op.runtimeMinutes == null) {
											insertionStatement_tDBSCD_1.setNull(8, java.sql.Types.VARCHAR);
										} else {
											insertionStatement_tDBSCD_1.setString(8, op.runtimeMinutes);
										}

										if (op.titleType == null) {
											insertionStatement_tDBSCD_1.setNull(9, java.sql.Types.VARCHAR);
										} else {
											insertionStatement_tDBSCD_1.setString(9, op.titleType);
										}

										if (op.startYear == null) {
											insertionStatement_tDBSCD_1.setNull(10, java.sql.Types.VARCHAR);
										} else {
											insertionStatement_tDBSCD_1.setString(10, op.startYear);
										}

										if (op.primaryTitle == null) {
											insertionStatement_tDBSCD_1.setNull(11, java.sql.Types.VARCHAR);
										} else {
											insertionStatement_tDBSCD_1.setString(11, op.primaryTitle);
										}

										int version_tDBSCD_1 = 1;
										insertionStatement_tDBSCD_1.setInt(12, version_tDBSCD_1);

										if (op.tconst == null) {
											insertionStatement_tDBSCD_1.setNull(13, java.sql.Types.DATE);
										} else {
											if (op.tconst != null) {
												date_tDBSCD_1 = op.tconst.getTime();
												if (date_tDBSCD_1 < year1_tDBSCD_1
														|| date_tDBSCD_1 >= year10000_tDBSCD_1) {
													insertionStatement_tDBSCD_1.setString(13, "0000-00-00 00:00:00");
												} else {
													insertionStatement_tDBSCD_1.setTimestamp(13,
															new java.sql.Timestamp(date_tDBSCD_1));
												}
											} else {
												insertionStatement_tDBSCD_1.setNull(13, java.sql.Types.DATE);
											}
										}

										nb_line_inserted_tDBSCD_1 += insertionStatement_tDBSCD_1.executeUpdate();
									} else {
										if (!cu_tDBSCD_1.scdEquals(lookUpValue_tDBSCD_1.DI_Created_Date,
												op.DI_Created_Date)
												|| (lookUpValue_tDBSCD_1.DI_JobId == null && op.DI_JobId != null)
												|| (lookUpValue_tDBSCD_1.DI_JobId != null
														&& !lookUpValue_tDBSCD_1.DI_JobId.equals(op.DI_JobId))
												|| (lookUpValue_tDBSCD_1.endYear == null && op.endYear != null)
												|| (lookUpValue_tDBSCD_1.endYear != null
														&& !lookUpValue_tDBSCD_1.endYear.equals(op.endYear))
												|| (lookUpValue_tDBSCD_1.genres == null && op.genres != null)
												|| (lookUpValue_tDBSCD_1.genres != null
														&& !lookUpValue_tDBSCD_1.genres.equals(op.genres))
												|| (lookUpValue_tDBSCD_1.originalTitle == null
														&& op.originalTitle != null)
												|| (lookUpValue_tDBSCD_1.originalTitle != null
														&& !lookUpValue_tDBSCD_1.originalTitle.equals(op.originalTitle))
												|| (lookUpValue_tDBSCD_1.isAdult == null && op.isAdult != null)
												|| (lookUpValue_tDBSCD_1.isAdult != null
														&& !lookUpValue_tDBSCD_1.isAdult.equals(op.isAdult))
												|| (lookUpValue_tDBSCD_1.runtimeMinutes == null
														&& op.runtimeMinutes != null)
												|| (lookUpValue_tDBSCD_1.runtimeMinutes != null
														&& !lookUpValue_tDBSCD_1.runtimeMinutes
																.equals(op.runtimeMinutes))
												|| (lookUpValue_tDBSCD_1.titleType == null && op.titleType != null)
												|| (lookUpValue_tDBSCD_1.titleType != null
														&& !lookUpValue_tDBSCD_1.titleType.equals(op.titleType))
												|| (lookUpValue_tDBSCD_1.startYear == null && op.startYear != null)
												|| (lookUpValue_tDBSCD_1.startYear != null
														&& !lookUpValue_tDBSCD_1.startYear.equals(op.startYear))) {
											if (op.DI_Created_Date == null) {
												updateForType1_tDBSCD_1.setNull(1, java.sql.Types.DATE);
											} else {
												if (op.DI_Created_Date != null) {
													date_tDBSCD_1 = op.DI_Created_Date.getTime();
													if (date_tDBSCD_1 < year1_tDBSCD_1
															|| date_tDBSCD_1 >= year10000_tDBSCD_1) {
														updateForType1_tDBSCD_1.setString(1, "0000-00-00 00:00:00");
													} else {
														updateForType1_tDBSCD_1.setTimestamp(1,
																new java.sql.Timestamp(date_tDBSCD_1));
													}
												} else {
													updateForType1_tDBSCD_1.setNull(1, java.sql.Types.DATE);
												}
											}

											if (op.DI_JobId == null) {
												updateForType1_tDBSCD_1.setNull(2, java.sql.Types.VARCHAR);
											} else {
												updateForType1_tDBSCD_1.setString(2, op.DI_JobId);
											}

											if (op.endYear == null) {
												updateForType1_tDBSCD_1.setNull(3, java.sql.Types.VARCHAR);
											} else {
												updateForType1_tDBSCD_1.setString(3, op.endYear);
											}

											if (op.genres == null) {
												updateForType1_tDBSCD_1.setNull(4, java.sql.Types.VARCHAR);
											} else {
												updateForType1_tDBSCD_1.setString(4, op.genres);
											}

											if (op.originalTitle == null) {
												updateForType1_tDBSCD_1.setNull(5, java.sql.Types.VARCHAR);
											} else {
												updateForType1_tDBSCD_1.setString(5, op.originalTitle);
											}

											if (op.isAdult == null) {
												updateForType1_tDBSCD_1.setNull(6, java.sql.Types.INTEGER);
											} else {
												updateForType1_tDBSCD_1.setByte(6, op.isAdult);
											}

											if (op.runtimeMinutes == null) {
												updateForType1_tDBSCD_1.setNull(7, java.sql.Types.VARCHAR);
											} else {
												updateForType1_tDBSCD_1.setString(7, op.runtimeMinutes);
											}

											if (op.titleType == null) {
												updateForType1_tDBSCD_1.setNull(8, java.sql.Types.VARCHAR);
											} else {
												updateForType1_tDBSCD_1.setString(8, op.titleType);
											}

											if (op.startYear == null) {
												updateForType1_tDBSCD_1.setNull(9, java.sql.Types.VARCHAR);
											} else {
												updateForType1_tDBSCD_1.setString(9, op.startYear);
											}

											if (op.tconst == null) {
												updateForType1_tDBSCD_1.setNull(10, java.sql.Types.VARCHAR);
											} else {
												updateForType1_tDBSCD_1.setString(10, op.tconst);
											}

											nb_line_update_tDBSCD_1 += updateForType1_tDBSCD_1.executeUpdate();
										}
										if ((lookUpValue_tDBSCD_1.primaryTitle == null && op.primaryTitle != null)
												|| (lookUpValue_tDBSCD_1.primaryTitle != null
														&& !lookUpValue_tDBSCD_1.primaryTitle
																.equals(op.primaryTitle))) {
											if (op.tconst == null) {
												updateForType2_tDBSCD_1.setNull(1, java.sql.Types.DATE);
											} else {
												if (op.tconst != null) {
													date_tDBSCD_1 = op.tconst.getTime();
													if (date_tDBSCD_1 < year1_tDBSCD_1
															|| date_tDBSCD_1 >= year10000_tDBSCD_1) {
														updateForType2_tDBSCD_1.setString(1, "0000-00-00 00:00:00");
													} else {
														updateForType2_tDBSCD_1.setTimestamp(1,
																new java.sql.Timestamp(date_tDBSCD_1));
													}
												} else {
													updateForType2_tDBSCD_1.setNull(1, java.sql.Types.DATE);
												}
											}

											if (op.tconst == null) {
												updateForType2_tDBSCD_1.setNull(2, java.sql.Types.VARCHAR);
											} else {
												updateForType2_tDBSCD_1.setString(2, op.tconst);
											}

											nb_line_update_tDBSCD_1 += updateForType2_tDBSCD_1.executeUpdate();
											if (op.tconst == null) {
												insertionStatement_tDBSCD_1.setNull(1, java.sql.Types.VARCHAR);
											} else {
												insertionStatement_tDBSCD_1.setString(1, op.tconst);
											}

											if (op.DI_Created_Date == null) {
												insertionStatement_tDBSCD_1.setNull(2, java.sql.Types.DATE);
											} else {
												if (op.DI_Created_Date != null) {
													date_tDBSCD_1 = op.DI_Created_Date.getTime();
													if (date_tDBSCD_1 < year1_tDBSCD_1
															|| date_tDBSCD_1 >= year10000_tDBSCD_1) {
														insertionStatement_tDBSCD_1.setString(2, "0000-00-00 00:00:00");
													} else {
														insertionStatement_tDBSCD_1.setTimestamp(2,
																new java.sql.Timestamp(date_tDBSCD_1));
													}
												} else {
													insertionStatement_tDBSCD_1.setNull(2, java.sql.Types.DATE);
												}
											}

											if (op.DI_JobId == null) {
												insertionStatement_tDBSCD_1.setNull(3, java.sql.Types.VARCHAR);
											} else {
												insertionStatement_tDBSCD_1.setString(3, op.DI_JobId);
											}

											if (op.endYear == null) {
												insertionStatement_tDBSCD_1.setNull(4, java.sql.Types.VARCHAR);
											} else {
												insertionStatement_tDBSCD_1.setString(4, op.endYear);
											}

											if (op.genres == null) {
												insertionStatement_tDBSCD_1.setNull(5, java.sql.Types.VARCHAR);
											} else {
												insertionStatement_tDBSCD_1.setString(5, op.genres);
											}

											if (op.originalTitle == null) {
												insertionStatement_tDBSCD_1.setNull(6, java.sql.Types.VARCHAR);
											} else {
												insertionStatement_tDBSCD_1.setString(6, op.originalTitle);
											}

											if (op.isAdult == null) {
												insertionStatement_tDBSCD_1.setNull(7, java.sql.Types.INTEGER);
											} else {
												insertionStatement_tDBSCD_1.setByte(7, op.isAdult);
											}

											if (op.runtimeMinutes == null) {
												insertionStatement_tDBSCD_1.setNull(8, java.sql.Types.VARCHAR);
											} else {
												insertionStatement_tDBSCD_1.setString(8, op.runtimeMinutes);
											}

											if (op.titleType == null) {
												insertionStatement_tDBSCD_1.setNull(9, java.sql.Types.VARCHAR);
											} else {
												insertionStatement_tDBSCD_1.setString(9, op.titleType);
											}

											if (op.startYear == null) {
												insertionStatement_tDBSCD_1.setNull(10, java.sql.Types.VARCHAR);
											} else {
												insertionStatement_tDBSCD_1.setString(10, op.startYear);
											}

											if (op.primaryTitle == null) {
												insertionStatement_tDBSCD_1.setNull(11, java.sql.Types.VARCHAR);
											} else {
												insertionStatement_tDBSCD_1.setString(11, op.primaryTitle);
											}

											int maxVersion_tDBSCD_1 = lookUpValue_tDBSCD_1.scd_version + 1;
											lookUpValue_tDBSCD_1.scd_version = lookUpValue_tDBSCD_1.scd_version + 1;
											insertionStatement_tDBSCD_1.setInt(12, maxVersion_tDBSCD_1);

											if (op.tconst == null) {
												insertionStatement_tDBSCD_1.setNull(13, java.sql.Types.DATE);
											} else {
												if (op.tconst != null) {
													date_tDBSCD_1 = op.tconst.getTime();
													if (date_tDBSCD_1 < year1_tDBSCD_1
															|| date_tDBSCD_1 >= year10000_tDBSCD_1) {
														insertionStatement_tDBSCD_1.setString(13,
																"0000-00-00 00:00:00");
													} else {
														insertionStatement_tDBSCD_1.setTimestamp(13,
																new java.sql.Timestamp(date_tDBSCD_1));
													}
												} else {
													insertionStatement_tDBSCD_1.setNull(13, java.sql.Types.DATE);
												}
											}

											nb_line_inserted_tDBSCD_1 += insertionStatement_tDBSCD_1.executeUpdate();
										}
									}

								} catch (java.lang.Exception e) {// catch
									globalMap.put("tDBSCD_1_ERROR_MESSAGE", e.getMessage());

									System.err.print(e.getMessage());
								} // end catch
								lookUpValue_tDBSCD_1.DI_Created_Date = op.DI_Created_Date;
								lookUpValue_tDBSCD_1.DI_JobId = op.DI_JobId;
								lookUpValue_tDBSCD_1.endYear = op.endYear;
								lookUpValue_tDBSCD_1.genres = op.genres;
								lookUpValue_tDBSCD_1.originalTitle = op.originalTitle;
								lookUpValue_tDBSCD_1.isAdult = op.isAdult;
								lookUpValue_tDBSCD_1.runtimeMinutes = op.runtimeMinutes;
								lookUpValue_tDBSCD_1.titleType = op.titleType;
								lookUpValue_tDBSCD_1.startYear = op.startYear;
								lookUpValue_tDBSCD_1.primaryTitle = op.primaryTitle;
								cache_tDBSCD_1.put(lookUpKey_tDBSCD_1, lookUpValue_tDBSCD_1);

								tos_count_tDBSCD_1++;

								/**
								 * [tDBSCD_1 main ] stop
								 */

								/**
								 * [tDBSCD_1 process_data_begin ] start
								 */

								currentComponent = "tDBSCD_1";

								cLabel = "\"scd_title_basics\"";

								/**
								 * [tDBSCD_1 process_data_begin ] stop
								 */

								/**
								 * [tDBSCD_1 process_data_end ] start
								 */

								currentComponent = "tDBSCD_1";

								cLabel = "\"scd_title_basics\"";

								/**
								 * [tDBSCD_1 process_data_end ] stop
								 */

							} // End of branch "op"

							/**
							 * [tMap_1 process_data_end ] start
							 */

							currentComponent = "tMap_1";

							/**
							 * [tMap_1 process_data_end ] stop
							 */

						} // End of branch "row1"

						/**
						 * [tFileInputJSON_1 process_data_end ] start
						 */

						currentComponent = "tFileInputJSON_1";

						cLabel = "title_basics";

						/**
						 * [tFileInputJSON_1 process_data_end ] stop
						 */

						/**
						 * [tFileInputJSON_1 end ] start
						 */

						currentComponent = "tFileInputJSON_1";

						cLabel = "title_basics";

					}
					globalMap.put("tFileInputJSON_1_NB_LINE", nb_line_tFileInputJSON_1);
					log.debug("tFileInputJSON_1 - Retrieved records count: " + nb_line_tFileInputJSON_1 + " .");

					if (log.isDebugEnabled())
						log.debug("tFileInputJSON_1 - " + ("Done."));

					ok_Hash.put("tFileInputJSON_1", true);
					end_Hash.put("tFileInputJSON_1", System.currentTimeMillis());

					/**
					 * [tFileInputJSON_1 end ] stop
					 */

					/**
					 * [tMap_1 end ] start
					 */

					currentComponent = "tMap_1";

// ###############################
// # Lookup hashes releasing
// ###############################      
					log.debug("tMap_1 - Written records count in the table 'op': " + count_op_tMap_1 + ".");

					if (runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, "row1", 2, 0,
							"tFileInputJSON_1", "title_basics", "tFileInputJSON", "tMap_1", "tMap_1", "tMap",
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
					 * [tDBSCD_1 end ] start
					 */

					currentComponent = "tDBSCD_1";

					cLabel = "\"scd_title_basics\"";

					insertionStatement_tDBSCD_1.close();
					updateForType1_tDBSCD_1.close();
					updateForType2_tDBSCD_1.close();
					if (connection_tDBSCD_1 != null && !connection_tDBSCD_1.isClosed()) {
						connection_tDBSCD_1.close();
					}
					globalMap.put("tDBSCD_1_NB_LINE_UPDATED", nb_line_update_tDBSCD_1);
					globalMap.put("tDBSCD_1_NB_LINE_INSERTED", nb_line_inserted_tDBSCD_1);
					globalMap.put("tDBSCD_1_NB_LINE_REJECTED", nb_line_rejected_tDBSCD_1);

					if (runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, "op", 2, 0, "tMap_1",
							"tMap_1", "tMap", "tDBSCD_1", "\"scd_title_basics\"", "tMysqlSCD", "output")) {
						talendJobLogProcess(globalMap);
					}

					ok_Hash.put("tDBSCD_1", true);
					end_Hash.put("tDBSCD_1", System.currentTimeMillis());

					/**
					 * [tDBSCD_1 end ] stop
					 */

					if (execStat) {
						runStat.updateStatOnConnection("iterate1", 2, "exec" + NB_ITERATE_tFileInputJSON_1);
					}

					/**
					 * [tFileList_1 process_data_end ] start
					 */

					currentComponent = "tFileList_1";

					/**
					 * [tFileList_1 process_data_end ] stop
					 */

					/**
					 * [tFileList_1 end ] start
					 */

					currentComponent = "tFileList_1";

				}
				globalMap.put("tFileList_1_NB_FILE", NB_FILEtFileList_1);

				log.info("tFileList_1 - File or directory count : " + NB_FILEtFileList_1);

				if (log.isDebugEnabled())
					log.debug("tFileList_1 - " + ("Done."));

				ok_Hash.put("tFileList_1", true);
				end_Hash.put("tFileList_1", System.currentTimeMillis());

				/**
				 * [tFileList_1 end ] stop
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
				 * [tFileList_1 finally ] start
				 */

				currentComponent = "tFileList_1";

				/**
				 * [tFileList_1 finally ] stop
				 */

				/**
				 * [tFileInputJSON_1 finally ] start
				 */

				currentComponent = "tFileInputJSON_1";

				cLabel = "title_basics";

				/**
				 * [tFileInputJSON_1 finally ] stop
				 */

				/**
				 * [tMap_1 finally ] start
				 */

				currentComponent = "tMap_1";

				/**
				 * [tMap_1 finally ] stop
				 */

				/**
				 * [tDBSCD_1 finally ] start
				 */

				currentComponent = "tDBSCD_1";

				cLabel = "\"scd_title_basics\"";

				/**
				 * [tDBSCD_1 finally ] stop
				 */

			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tFileList_1_SUBPROCESS_STATE", 1);
	}

	public void talendJobLogProcess(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("talendJobLog_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		mdcInfo.forEach(org.slf4j.MDC::put);
		org.slf4j.MDC.put("_subJobName", "talendJobLog");
		org.slf4j.MDC.put("_subJobPid", "IqrKT3_" + subJobPidCounter.getAndIncrement());

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
		final scd_title_basics scd_title_basicsClass = new scd_title_basics();

		int exitCode = scd_title_basicsClass.runJobInTOS(args);
		if (exitCode == 0) {
			log.info("TalendJob: 'scd_title_basics' - Done.");
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
		log.info("TalendJob: 'scd_title_basics' - Start.");

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
		org.slf4j.MDC.put("_jobRepositoryId", "_6pgfIJIkEe63wpxH0JsEEw");
		org.slf4j.MDC.put("_compiledAtTimestamp", "2023-12-03T22:29:49.803885200Z");

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
			java.io.InputStream inContext = scd_title_basics.class.getClassLoader()
					.getResourceAsStream("group14final/scd_title_basics_0_1/contexts/" + contextStr + ".properties");
			if (inContext == null) {
				inContext = scd_title_basics.class.getClassLoader()
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
					context.setContextType("str_title_basics", "id_String");
					if (context.getStringValue("str_title_basics") == null) {
						context.str_title_basics = null;
					} else {
						context.str_title_basics = (String) context.getProperty("str_title_basics");
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
			if (parentContextMap.containsKey("str_title_basics")) {
				context.str_title_basics = (String) parentContextMap.get("str_title_basics");
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
		log.info("TalendJob: 'scd_title_basics' - Started.");
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
			tDBRow_1Process(globalMap);
			if (!"failure".equals(status)) {
				status = "end";
			}
		} catch (TalendException e_tDBRow_1) {
			globalMap.put("tDBRow_1_SUBPROCESS_STATE", -1);

			e_tDBRow_1.printStackTrace();

		}
		try {
			errorCode = null;
			tFileList_1Process(globalMap);
			if (!"failure".equals(status)) {
				status = "end";
			}
		} catch (TalendException e_tFileList_1) {
			globalMap.put("tFileList_1_SUBPROCESS_STATE", -1);

			e_tFileList_1.printStackTrace();

		}

		this.globalResumeTicket = true;// to run tPostJob

		end = System.currentTimeMillis();

		if (watch) {
			System.out.println((end - startTime) + " milliseconds");
		}

		endUsedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		if (false) {
			System.out.println(
					(endUsedMemory - startUsedMemory) + " bytes memory increase when running : scd_title_basics");
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
		log.info("TalendJob: 'scd_title_basics' - Finished - status: " + status + " returnCode: " + returnCode);

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
 * 157284 characters generated by Talend Cloud Data Fabric on the December 3,
 * 2023 at 5:29:49 PM EST
 ************************************************************************************************/
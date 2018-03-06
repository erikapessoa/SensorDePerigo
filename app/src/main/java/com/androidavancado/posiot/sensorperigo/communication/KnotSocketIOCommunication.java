package com.androidavancado.posiot.sensorperigo.communication;

import com.androidavancado.posiot.sensorperigo.model.ButtonData;
import com.androidavancado.posiot.sensorperigo.model.ButtonDevice;
import com.androidavancado.posiot.sensorperigo.util.Constants;
import com.androidavancado.posiot.sensorperigo.util.Logger;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.util.List;

import br.org.cesar.knot.lib.connection.FacadeConnection;
import br.org.cesar.knot.lib.event.Event;
import br.org.cesar.knot.lib.exception.InvalidParametersException;
import br.org.cesar.knot.lib.exception.KnotException;
import br.org.cesar.knot.lib.exception.SocketNotConnected;
import br.org.cesar.knot.lib.model.KnotList;
import br.org.cesar.knot.lib.model.KnotQueryData;
import br.org.cesar.knot.lib.model.KnotQueryDateData;
import br.org.cesar.knot.lib.util.DateUtils;

/**
 * Created by erika on 25/02/18.
 */

public class KnotSocketIOCommunication implements IKnotCommunication  {

    private static final String ENDPOINT = Constants.KNOT_URL;
    private static final String UUID_OWNER = Constants.DEFAULT_UUID;
    private static final String TOKEN_OWNER = Constants.DEFAULT_TOKEN;

    private static final Object lock = new Object();

    /**
     * Class used to access the db repository
     */
    //private FacadeDatabase mDrinkFountainDB;

    /**
     * Class used to access knot LIB
     */
    public FacadeConnection mKnotApi;

    private List<ButtonDevice> mSwitchDeviceList;

    private List<ButtonData> mSwitchDataList;

    /**
     * Only Instance
     */
    private static KnotSocketIOCommunication sInstance;


    /**
     * Private constructor
     */
    private KnotSocketIOCommunication() {
        //Initializing the KNOT API
        mKnotApi = FacadeConnection.getInstance();
        mKnotApi.setupSocketIO(UUID_OWNER, TOKEN_OWNER);
    }

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static KnotSocketIOCommunication getInstance() {
        synchronized (lock) {
            if (sInstance == null) {
                sInstance = new KnotSocketIOCommunication();
            }
            return sInstance;
        }
    }

    /**
     * Authenticating the socket communication
     *
     * @param callbackResult Callback that will receive the result
     */
    public void authenticateSocketCommunication(final Event<Boolean> callbackResult) {

        try {
            mKnotApi.connectSocket(ENDPOINT, new Event<Boolean>() {
                @Override
                public void onEventFinish(Boolean object) {
                    try {
                        mKnotApi.socketIOAuthenticateDevice(callbackResult);
                    } catch (SocketNotConnected socketNotConnected) {
                        // LogKnotDrinkFountain.printE(socketNotConnected);
                    } catch (InvalidParametersException e) {
                        // LogKnotDrinkFountain.printE(e);
                    }
                }

                @Override
                public void onEventError(Exception e) {
                    //  LogKnotDrinkFountain.printE(e);
                    callbackResult.onEventError(e);
                }
            });
        } catch (SocketNotConnected socketNotConnected) {
            socketNotConnected.printStackTrace();
            callbackResult.onEventError(socketNotConnected);
        }

    }

    @Override
    public void getAllDevices() {
        KnotList<ButtonDevice> mDrinkFountainDeviceList = new KnotList<>(ButtonDevice.class);

        JSONArray ja = new JSONArray();
        //ID do gateway, * to all
        ja.put("*");

        JSONObject query = new JSONObject();
        try {
            query.put("gateways", ja);
        } catch (JSONException e) {
            //LogKnotDrinkFountain.printE(e);
        }

        try {
            mKnotApi.socketIOGetDeviceList(mDrinkFountainDeviceList, query, new Event<List<ButtonDevice>>() {

                @Override
                public void onEventFinish(List<ButtonDevice> deviceList) {
                    Logger.d("lista de devices size = " + deviceList.size());
                    if (deviceList != null) {
                        mSwitchDeviceList = deviceList;
                        for (ButtonDevice d : deviceList){
                            // Log.d("Diego", "Desc = " +  d.getUuid());
                            Logger.d("=============DEVICE===============");
                            Logger.d("UUID = " + d.getUuid());
                            //getDataByDevice();
                        }
                    }
                }

                @Override
                public void onEventError(Exception e) {
                    //LogKnotDrinkFountain.printE(e);
                    //KnotHttpCommunication.getInstance().getDataByDevice();
                }
            });
        } catch (KnotException e) {
            //LogKnotDrinkFountain.printE(e);
            e.printStackTrace();
        } catch (SocketNotConnected socketNotConnected) {
            // LogKnotDrinkFountain.printE(socketNotConnected);
            socketNotConnected.printStackTrace();
        } catch (InvalidParametersException e) {
            // LogKnotDrinkFountain.printE(e);
            e.printStackTrace();
        }
    }

    @Override
    public void getDataByDevice() {

        KnotList<ButtonData> switchDataList = new KnotList<>(ButtonData.class);

        for (final ButtonDevice drinkFountainDevice : mSwitchDeviceList) {

            // get the last valid waterLevelData to build the query
            //ButtonData waterLevelData = mSwitchDataList.get(0);

            KnotQueryDateData knotQueryDateDataStart = null;
            KnotQueryDateData knotQueryDateDataFinish = null;

            try {
                //get the current hour of the system
                knotQueryDateDataFinish = DateUtils.getCurrentKnotQueryDateData();

                KnotQueryData knotQueryData = new KnotQueryData();
                knotQueryData.setFinishDate(knotQueryDateDataFinish);
                //        setStartDate(knotQueryDateDataStart
                // );

                mKnotApi.socketIOGetData(switchDataList, UUID_OWNER, TOKEN_OWNER, null, new Event<List<ButtonData>>() {
                    @Override
                    public void onEventFinish(List<ButtonData> list) {
                        try {
                            mSwitchDataList = list;

                            if (mSwitchDataList != null) {
                                for (ButtonData data : mSwitchDataList){
                                    Logger.d("==============DATA===================");
                                    Logger.d(Boolean.toString(data.getMCurrentValue()));
                                }
                            }
                        } catch (Exception e) {
                            Logger.d("==============EXCEPTION===================");
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onEventError(Exception e) {
                        //LogKnotDrinkFountain.printE(e);
                    }
                });
            } catch (ParseException e) {
                e.printStackTrace();
            } catch (InvalidParametersException e) {
                e.printStackTrace();
            } catch (SocketNotConnected socketNotConnected) {
                socketNotConnected.printStackTrace();
            }


        }


    }
}

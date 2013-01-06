stockwatcher-in-activity
========================

A best practice of classic stockwatcher in GWT activity/place framework with multiple display.

ClientFactory:

As a factory, responsible for create ActivityMapper, ActivityManager, EventBus, PlaceContaoller, and implements getPlace, getView
NOTE: getView is implemented by its sub-class, so different implementation(Desktop/Mobile) return different View.

Activity:

Responsible for init view, and update view according data, handle process all logic, including calling backend service.

CompositeActivity is a kind of Activity which has sub-activities, see StockWatcherActivity.
SubAcitivity doesn't have a place.

Place:
Place can handle Sting-nize Object, so the parameter can be transfer to Acticity.

View:

Responsible for organizing widget, generally by UI binder, and handle events.
Has reference to Activity, call Activity to process all logic.

For multiple display View, see stockwatcher view and buystock viewes & activities.